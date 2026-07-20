public class PasswordStrengthChecker
{
    public static String checkStrength(String password)
    {
        int score = 0;

        if (password.length() >= 8)
        {
            score++;
        }
        if (password.length() >= 12)
        {
            score++;
        }
        if (password.matches(".*[A-Z].*"))
        {
            score++;      // has uppercase
        }
        if (password.matches(".*[a-z].*"))
        {
            score++;      // has lowercase
        }
        if (password.matches(".*[0-9].*"))
        {
            score++;      // has number
        }
        if (password.matches(".*[!@#$%^&*(),.?\":{}|<>].*"))
        {
            score++; // has symbol
        }

        if (score <= 2)
        {
            return "Weak";
        }
        else if (score <= 4)
        {
            return "Medium";
        }
        else
        {
            return "Strong";
        }
    }
}