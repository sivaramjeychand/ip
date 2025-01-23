import java.util.Scanner;

public class HamiltonianGuy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("______________________________________");
        System.out.println("Hello from I'm HamiltonianGuy");
        System.out.println("What can I do for you?");
        System.out.println("______________________________________");
        TodoList todoList = new TodoList();

        while (true) {
            String s = sc.nextLine();
            if (s.equals("bye")) {
                break;
            } else if (s.equals("list")) {
                todoList.printList();
            } else if (s.startsWith("mark ")) {
                int index = Integer.parseInt(s.split(" ")[1]) - 1;
                todoList.markItem(index);
                System.out.println("      Nice! I've marked this task as done: " );
                todoList.printElement(index);
            } else if (s.startsWith("unmark ")) {
                int index = Integer.parseInt(s.split(" ")[1]) - 1;
                todoList.unmarkItem(index);
                System.out.println("      OK, I've marked this task as not done yet:" );
                todoList.printElement(index);
            } else {
                todoList.addItem(s);
                System.out.println("      added: " + s);
            }
        }
        System.out.println("      Bye. Hope to see you again.");
        sc.close();
    }
}
