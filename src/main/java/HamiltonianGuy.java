import java.util.Scanner;

public class HamiltonianGuy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("______________________________________");
        System.out.println("Hello from I'm HamiltonianGuy");
        System.out.println("What can I do for you?");
        System.out.println("______________________________________");
        TaskList t = new TaskList();

        while (true) {
            String input = sc.nextLine();
            if (input.equals("bye")) {
                break;
            } else if (input.equals("list")) {
                t.printList();
            } else if (input.startsWith("mark ")) {
                int index = Integer.parseInt(input.split(" ")[1]) - 1;
                t.markTask(index);
            } else if (input.startsWith("unmark ")) {
                int index = Integer.parseInt(input.split(" ")[1]) - 1;
                t.unmarkTask(index);
            } else if (input.startsWith("todo ")) {
                String desc = input.substring(5);
                t.addTask(new ToDoTask(desc));
                System.out.println("      Added: " + desc);
            } else if (input.startsWith("deadline ")) {
                String[] parts = input.substring(9).split(" /by ");
                String desc = parts[0];
                String by = parts[1];
                t.addTask(new DeadlineTask(desc, by));
                System.out.println("      Added: " + desc + " (by: " + by + ")");
            } else if (input.startsWith("event ")) {
                String[] parts = input.substring(6).split(" /from ");
                String desc = parts[0];
                String[] time = parts[1].split(" /to ");
                String from = time[0];
                String to = time[1];
                t.addTask(new EventTask(desc, from, to));
                System.out.println("      Added: " + desc + " (from: " + from + " to: " + to + ")");
            }
        }
        System.out.println("      Bye. Hope to see you again.");
        sc.close();
    }
}
