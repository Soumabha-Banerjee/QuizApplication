import quiz.Login;

public class Main {
    public static void main(String[] args) {
        try {
            new Login();
        } catch (Exception exp) {
            System.out.println("Error Occurred: " + exp);
        }
    }
}
