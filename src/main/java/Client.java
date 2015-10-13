/**
 * Created by User on 12.10.2015.
 */
public class Client {
    private int Client_id;
    private String firstName;
     private String lastName;

    @Override
    public String toString() {
        return "Client{" +
                "Client_id=" + Client_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", addres='" + addres + '\'' +
                '}';
    }

    private String addres;

    public Client(int client_id, String firstName, String lastName, String addres) {
        Client_id = client_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addres = addres;
    }

    public int getClient_id() {
        return Client_id;
    }

    public void setClient_id(int client_id) {
        Client_id = client_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }


}
