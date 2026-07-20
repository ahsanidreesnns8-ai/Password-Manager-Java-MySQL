import java.sql.Connection;
import java.sql.DriverManager;

class TestConnection
{
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3306/password_manager";
        String user = "root";
        String password = "ahsanidrees1044";

        try (Connection conn = DriverManager.getConnection(url, user, password))
        {
            System.out.println("Connected successfully!");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}