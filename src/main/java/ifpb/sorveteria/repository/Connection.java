package ifpb.sorveteria.repository;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    private static final String URL = 	"jdbc:postgresql://ep-empty-voice-ac21mgo9-pooler.sa-east-1.aws.neon.tech:5432/DataBaseSorveteria?sslmode=require";
    private static final String USER = "DataBaseSorveteria_owner";
    private static final String PASSWORD = "npg_CjkYQ5fUPi4A";

    public static java.sql.Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }

}