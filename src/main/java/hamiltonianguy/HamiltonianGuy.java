package hamiltonianguy;

import hamiltonianguy.tasks.*;
import hamiltonianguy.storage.*;

import java.util.Scanner;


/**
 * The main entry point for the HamiltonianGuy chatbot.
 * Handles user input and commands.
 */

public class HamiltonianGuy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Storage storage = new Storage("./data/HamiltonianGuy.txt");
        TaskList taskList = new TaskList(storage);

        System.out.println("______________________________________");
        System.out.println("Hello! I'm HamiltonianGuy.");
        System.out.println("What can I do for you?");
        System.out.println("______________________________________");

        while (true) {
            try {
                String input = sc.nextLine().trim();
                if (input.equals("bye")) {
                    break;
                } else if (input.equals("list")) {
                    if (taskList.isEmpty()) {
                        System.out.println("      OOPS!! The list is empty.");
                    }
                    taskList.printList();
                } else if (input.startsWith("mark")) {
                    handleMarkCommand(input, taskList);
                } else if (input.startsWith("unmark")) {
                    handleUnmarkCommand(input, taskList);
                } else if (input.startsWith("todo")) {
                    handleTodoCommand(input, taskList);
                } else if (input.startsWith("deadline")) {
                    handleDeadlineCommand(input, taskList);
                } else if (input.startsWith("event")) {
                    handleEventCommand(input, taskList);
                } else if (input.startsWith("delete")) {
                    handleDeleteCommand(input, taskList);
                } else {
                    throw new IllegalArgumentException("OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("      " + e.getMessage());
            } catch (Exception e) {
                System.out.println("      OOPS!!! Something went wrong: " + e.getMessage());
            }
        }

        System.out.println("      Bye. Hope to see you again!");
        sc.close();
    }

    private static void handleMarkCommand(String input, TaskList taskList) {
        try {
            int index = Integer.parseInt(input.split(" ")[1]) - 1;
            taskList.markTask(index);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("OOPS!!! Please provide a valid number for the task index.");
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("OOPS!!! The task index is out of range.");
        }
    }

    private static void handleUnmarkCommand(String input, TaskList taskList) {
        try {
            int index = Integer.parseInt(input.split(" ")[1]) - 1;
            taskList.unmarkTask(index);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("OOPS!!! Please provide a valid number for the task index.");
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("OOPS!!! The task index is out of range.");
        }
    }

    private static void handleTodoCommand(String input, TaskList taskList) {
        String description = input.substring(4).trim();
        if (description.isEmpty()) {
            throw new IllegalArgumentException("OOPS!!! The description of a todo cannot be empty.");
        }
        taskList.addTask(new ToDoTask(description));
        System.out.println("      Added: " + description);
    }

    private static void handleDeadlineCommand(String input, TaskList taskList) {
        try {
            String[] parts = input.substring(8).split(" /by ");
            String desc = parts[0].trim();
            String by = parts[1].trim();
            if (desc.isEmpty() || by.isEmpty()) {
                throw new IllegalArgumentException("OOPS!!! Both description and deadline must be provided.");
            }
            taskList.addTask(new DeadlineTask(desc, by));
            System.out.println("      Added: " + desc + " (by: " + by + ")");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("OOPS!!! Please provide a description and a deadline in the format: deadline <description> /by yyyy-MM-dd HHmm");
        }
    }

    private static void handleEventCommand(String input, TaskList taskList) {
        try {
            String[] parts = input.substring(5).split(" /from ");
            String desc = parts[0].trim();
            String[] timeParts = parts[1].split(" /to ");
            String from = timeParts[0].trim();
            String to = timeParts[1].trim();
            if (desc.isEmpty() || from.isEmpty() || to.isEmpty()) {
                throw new IllegalArgumentException("OOPS!!! Description, start, and end times must be provided.");
            }
            taskList.addTask(new EventTask(desc, from, to));
            System.out.println("      Added: " + desc + " (from: " + from + " to: " + to + ")");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("OOPS!!! Please provide a description and times in the format: event <description> /from yyyy-MM-dd HHmm /to yyyy-MM-dd HHmm");
        }
    }


    private static void handleDeleteCommand(String input, TaskList taskList) {
        try {
            int index = Integer.parseInt(input.split(" ")[1]) - 1;
            taskList.deleteTask(index);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("OOPS!!! Please provide a valid number for the task index.");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("OOPS!!! Please specify the task to delete in the format: delete <index>");
        }
    }
}
