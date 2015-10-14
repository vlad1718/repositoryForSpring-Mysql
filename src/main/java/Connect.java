/**
 * Created by User on 12.10.2015.
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.*;

/**
 * Created by User on 12.10.2015.
 */
public class Connect implements ClientDao {
    private DataSource ds;

    public Connect(){

    }


    public void insert(Client client) {

        String sql = "Insert into client " + "(idClient, FirstName, LastName,Adress) VALUES (?, ?, ?,?)";
        Connection conn = null;
        try {
            conn = ds.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, client.getClient_id());
            ps.setString(2, client.getFirstName());
            ps.setString(3, client.getLastName());
            ps.setString(4, client.getAddres());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            Logger log = LoggerFactory.getLogger("name");
            log.info(e.toString());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
    }


    public Client find(int idClient) {
        String sql = "Select *from client Where idClient =?";
        Connection conn = null;
        try {

            conn = ds.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idClient);
            Client client = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                client = new Client(
                        rs.getInt("idClient"),
                        rs.getString("FirstName"),
                        rs.getString("LastName"),
                        rs.getString("Adress")
                );
            }
            rs.close();
            ps.close();
            return client;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
    }
    public void delete(int idClient){
       String  sql = "DELETE FROM client WHERE idClient ='" + idClient
                + "'";
        Connection conn = null;
        try {

            conn = ds.getConnection();
            Statement db = conn.createStatement();
            db.executeUpdate(sql);
            db.close();


    } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
   }

    public void setDs(DataSource ds) {
        this.ds = ds;
    }
}
