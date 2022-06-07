package dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

public class BusStopTable {
    private ArrayList<String> nameOfBusStop;

    public void init(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ArrayList<String> buffer = new ArrayList<>();
        Configs configs = new Configs();
        PrintWriter pw = response.getWriter();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://" + configs.dbHost + ":" + configs.dbPort + "/" + configs.dbName,
                    configs.dbUser,
                    configs.dbPass);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT nameOfTranspStop from transportstop");


            while (rs.next()) {
                buffer.add(rs.getString("nameOfTranspStop"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        nameOfBusStop = buffer;
    }


    public void setNameOfBusStop(ArrayList<String> nameOfBusStop) {
        this.nameOfBusStop = nameOfBusStop;
    }

    public ArrayList<String> getNameOfBusStop() {
        return nameOfBusStop;
    }
}
