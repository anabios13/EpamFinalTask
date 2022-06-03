import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


public class ScheduleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            while (rs.next()){
                pw.println(rs.getString("nameOfTranspStop"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //    response.setContentType("myText/html");
    }
}
