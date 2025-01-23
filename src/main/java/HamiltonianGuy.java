import java.util.Scanner;
import java.util.ArrayList;

public class HamiltonianGuy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("______________________________________");
        System.out.println("Hello from I'm HamiltonianGuy");
        System.out.println("What can I do for you?");
        System.out.println("______________________________________");
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = sc.nextLine();
            if (s.equals("bye")) {
                break;
            } else if (s.equals("list")){
                for (int i = 0; i < list.size(); i++) {
                    System.out.println("      " + (i + 1) + ". " + list.get(i));
                }
            } else {
                list.add(s);
                System.out.println("      " + "added: " + s);
            }
        }
        System.out.println("      Bye. Hope to see you again.");
        sc.close();
    }
}
