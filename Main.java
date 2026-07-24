import java.util.Scanner;
import javax.crypto.SecretKey;


public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Password Manager ===");

        while (running)
        {
            System.out.println("\n1. Add Password");
            System.out.println("2. Delete Password");
            System.out.println("3. Search Password");
            System.out.println("4. Edit Password");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice)
            {
                case 1:
                    addPassword(scanner);
                    break;
                case 2:
                    deletePassword(scanner);
                    break;
                case 3:
                    searchPassword(scanner);
                    break;
                case 4:
                    editPassword(scanner);
                    break;
                case 5:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option, try again.");
            }
        }
        scanner.close();
    }

    private static void addPassword(Scanner scanner)
    {
        System.out.print("Enter site name: ");
        String site = scanner.nextLine();

        System.out.print("Enter username for this site: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        String strength = PasswordStrengthChecker.checkStrength(password);
        System.out.println("Password strength: " + strength);


        try {
            SecretKey key = getTemporaryKey();
            byte[] iv = CryptoUtil.generateIV();
            byte[] encryptedBytes = CryptoUtil.encrypt(password, key, iv);

            String encryptedBase64 = CryptoUtil.toBase64(encryptedBytes);
            String ivBase64 = CryptoUtil.toBase64(iv);

            CredentialDAO.addCredential(site, username, encryptedBase64, ivBase64);

        }
        catch (Exception e)
        {
            System.out.println("Error while encrypting/saving: " + e.getMessage());
        }

    }

    private static void deletePassword(Scanner scanner)
    {
        System.out.print("Enter site name to delete: ");
        String site = scanner.nextLine();

        boolean deleted = CredentialDAO.deleteCredential(site);

        if (deleted) {
            System.out.println("Deleted successfully!");
        } else {
            System.out.println("No entry found with that site name.");
        }
    }

    private static void searchPassword(Scanner scanner)
    {
        System.out.print("Enter site name to search: ");
        String site = scanner.nextLine();

        String[] result = CredentialDAO.getCredential(site);

        if (result == null)
        {
            System.out.println("No entry found with that site name.");
            return;
        }

        String username = result[0];
        String encryptedBase64 = result[1];
        String ivBase64 = result[2];

        try
        {
            SecretKey key = getTemporaryKey();
            byte[] encryptedBytes = CryptoUtil.fromBase64(encryptedBase64);
            byte[] iv = CryptoUtil.fromBase64(ivBase64);

            String decryptedPassword = CryptoUtil.decrypt(encryptedBytes, key, iv);

            System.out.println("Site: " + site);
            System.out.println("Username: " + username);
            System.out.println("Password: " + decryptedPassword);
        }
        catch (Exception e)
        {
            System.out.println("Error while decrypting: " + e.getMessage());
        }
    }

    private static void editPassword(Scanner scanner)
    {
        System.out.print("Enter site name to edit: ");
        String site = scanner.nextLine();
        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();

        String strength = PasswordStrengthChecker.checkStrength(newPassword);
        System.out.println("New password strength: " + strength);

        try
        {
            SecretKey key = getTemporaryKey();
            byte[] iv = CryptoUtil.generateIV();
            byte[] encryptedBytes = CryptoUtil.encrypt(newPassword, key, iv);

            String encryptedBase64 = CryptoUtil.toBase64(encryptedBytes);
            String ivBase64 = CryptoUtil.toBase64(iv);

            boolean updated = CredentialDAO.updateCredential(site, encryptedBase64, ivBase64);

            if (updated)
            {
                System.out.println("Password updated successfully!");
            }
            else
            {
                System.out.println("No entry found with that site name.");
            }
        }
        catch (Exception e)
        {
            System.out.println("Error while encrypting/updating: " + e.getMessage());
        }
    }

    private static SecretKey getTemporaryKey() throws Exception
    {
        byte[] tempSalt = "1234567890123456".getBytes();
        return KeyDerivation.deriveKey("TemporaryMasterPassword123", tempSalt);
    }
}
