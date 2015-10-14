import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by User on 12.10.2015.
 */
public class Main {
    public static void main(String []args){
        Logger log = LoggerFactory.getLogger("name");


        ApplicationContext context =
                new ClassPathXmlApplicationContext("module.xml");

       ClientDao clientDAO = (ClientDao) context.getBean("Connect");
        Client client = new Client(2, "Peter","Petrovich","Schkalova 77");
       // clientDAO.insert(client);

       Client client1 = clientDAO.find(2);
       clientDAO.delete(1);
       log.info(client1.toString());
    }
}
