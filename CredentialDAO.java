import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.ResultSet;

public class CredentialDAO
{
    public static void addCredential(String siteName, String siteUsername, String encryptedPassword, String iv)
    {
        String sql = "INSERT INTO credentials (site_name, site_username, encrypted_password, iv) " +
                "VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, siteName);
            stmt.setString(2, siteUsername);
            stmt.setString(3, encryptedPassword);
            stmt.setString(4, iv);

            stmt.executeUpdate();
            System.out.println("Saved to database successfully!");
        }
        catch (Exception e)
        {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    public static boolean deleteCredential(String siteName)
    {
        String sql = "DELETE FROM credentials WHERE site_name = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, siteName);
            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0;
        }
        catch (Exception e)
        {
            System.out.println("Database error: " + e.getMessage());
            return false;
        }
    }


    public static String[] getCredential(String siteName)
    {
        String sql = "SELECT site_username, encrypted_password, iv FROM credentials WHERE site_name = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, siteName);
            ResultSet rs = stmt.executeQuery();

            if (rs.next())
            {
                String username = rs.getString("site_username");
                String encryptedPassword = rs.getString("encrypted_password");
                String iv = rs.getString("iv");

                return new String[] { username, encryptedPassword, iv };
            }
            else
            {
                return null; // no matching entry found
            }
        }
        catch (Exception e)
        {
            System.out.println("Database error: " + e.getMessage());
            return null;
        }
    }

    public static boolean updateCredential(String siteName, String encryptedPassword, String iv)
    {
        String sql = "UPDATE credentials SET encrypted_password = ?, iv = ? WHERE site_name = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, encryptedPassword);
            stmt.setString(2, iv);
            stmt.setString(3, siteName);

            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0;
        }
        catch (Exception e)
        {
            System.out.println("Database error: " + e.getMessage());
            return false;
        }
    }
}
