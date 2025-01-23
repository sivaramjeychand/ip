import java.util.Scanner;

public class HamiltonianGuy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("______________________________________");
        System.out.println("Hello from I'm HamiltonianGuy");
        System.out.println("What can I do for you?");
        System.out.println("______________________________________");
        while (true) {
            String s = sc.nextLine();
            if (s.equals("bye")) {
                break;
            } else {
                System.out.println("      " + s);
            }
        }
        System.out.println("      Bye. Hope to see you again.");
        sc.close();
    }
}
