import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}