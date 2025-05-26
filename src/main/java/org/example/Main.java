    package org.example;

    import org.example.classes.Task;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {

            List<Task> tasks = new ArrayList<Task>();
            System.out.println("----- TO-DO LIST -----");
            Scanner scanner = new Scanner(System.in);

            while(true){
                System.out.println("1. View tasks\n" +
                        "2. Add task\n" +
                        "3. Mark task as done\n" +
                        "4. Delete task\n" +
                        "5. Save & Exit");
                int input = scanner.nextInt();
                switch(input){
                    //get all tasks
                    case 1:
                        if(tasks.isEmpty()){
                            System.out.println("There are no tasks!\n");
                            break;
                        }
                        for(Task t : tasks){
                            System.out.println(t.getTask() + "\n");

                        }
                        break;
                    //create a task
                    case 2:
                        scanner.nextLine(); // consume leftover newline
                        System.out.println("\nLet's add a new task:\nTitle: ");
                        String title = scanner.nextLine();

                        System.out.println("Description: ");
                        String description = scanner.nextLine();

                        Task task = new Task(title, description);
                        tasks.add(task);
                        System.out.println("Task added!\n");
                        break;

                    //update task status
                    case 3:
                        if(tasks.isEmpty()){
                            System.out.println("There are no tasks!\n");
                            break;
                        }

                        System.out.println("Which task would you like to mark as done?");
                        for(int i = 0 ; i < tasks.size() ; i++){
                            System.out.println(i + " " + tasks.get(i).getTask() + "\n");
                        }
                        int t = scanner.nextInt();
                        try {
                            tasks.get(t).setCompleted();
                            System.out.println("Task marked as completed!\n");
                        }catch (Exception e){
                            System.out.println("An error occured!\n");
                            break;
                        }
                        break;


                    //delete task
                    case 4:
                        if(tasks.isEmpty()){
                            System.out.println("There are no tasks!\n");
                            break;
                        }

                        System.out.println("Which task would you like to delete?");
                        for(int i = 0 ; i < tasks.size() ; i++){
                            System.out.println(i + " " + tasks.get(i).getTask() + "\n");
                        }
                        int i = scanner.nextInt();
                        try {
                            tasks.remove(i);
                            System.out.println("Task deleted!\n");
                        }catch (Exception e){
                            System.out.println("An error occured!\n");
                            break;
                        }
                        break;
                    case 5:
                        System.out.println("Are you sure you want to exit? (y/n)");
                        char answer = scanner.next().charAt(0);
                        if(answer == 'y'){
                            return;
                        }
                        else
                            break;

                    default:
                        System.out.println("Please enter a valid option!\n");
                }
            }
        }
    }