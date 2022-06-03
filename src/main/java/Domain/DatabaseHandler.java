package Domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql//" + dbHost + ":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString,dbUser,dbPass);
        return dbConnection;
    }
    public void createDay(String typeOfTransp) throws SQLException, ClassNotFoundException {
        String insert="INSERT INTO"+ Const.USER_TABLE+"(" + Const.DAYS_TYPEOFTRANSP+")"+"VALUES(?)";
        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.setString(1,typeOfTransp);
        prSt.executeUpdate();
    }
}
