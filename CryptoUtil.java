import java.util.Scanner;

public class CryptoUtil
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

        // Next step: encrypt password + save to database
        // We'll wire this to CryptoUtil + CredentialDAO next
        System.out.println("(TODO: encrypt and save to database)");
    }

    private static void deletePassword(Scanner scanner)
    {
        System.out.print("Enter site name to delete: ");
        String site = scanner.nextLine();
        // TODO: delete from database
        System.out.println("(TODO: delete from database)");
    }

    private static void searchPassword(Scanner scanner)
    {
        System.out.print("Enter site name to search: ");
        String site = scanner.nextLine();
        // TODO: fetch from database, decrypt, display
        System.out.println("(TODO: fetch and decrypt from database)");
    }

    private static void editPassword(Scanner scanner)
    {
        System.out.print("Enter site name to edit: ");
        String site = scanner.nextLine();
        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();

        String strength = PasswordStrengthChecker.checkStrength(newPassword);
        System.out.println("New password strength: " + strength);

        // TODO: encrypt new password, update database
        System.out.println("(TODO: update database)");
    }
}