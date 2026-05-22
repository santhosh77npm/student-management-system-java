import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentDAO dao = new StudentDAO();

        int choice;

        do {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");

            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Update Student");
            System.out.println("5. Exit");

            System.out.println("Enter Choice:");
            choice = sc.nextInt();
            sc.nextLine();

            // ADD STUDENT
            if (choice == 1) {

                System.out.println("Enter Name:");
                String name = sc.nextLine();

                System.out.println("Enter Age:");
                int age = sc.nextInt();
                sc.nextLine();

                System.out.println("Enter Course:");
                String course = sc.nextLine();

                System.out.println("Enter Email:");
                String email = sc.nextLine();

                Student s = new Student(name, age, course, email);

                dao.addStudent(s);
            }

            // VIEW STUDENTS
            else if (choice == 2) {

                dao.viewStudents();
            }

            // DELETE STUDENT
            else if (choice == 3) {

                System.out.println("Enter Student ID:");
                int id = sc.nextInt();

                dao.deleteStudent(id);
            }

            // UPDATE STUDENT
            else if (choice == 4) {

                System.out.println("Enter Student ID:");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.println("Enter New Name:");
                String name = sc.nextLine();

                System.out.println("Enter New Age:");
                int age = sc.nextInt();
                sc.nextLine();

                System.out.println("Enter New Course:");
                String course = sc.nextLine();

                System.out.println("Enter New Email:");
                String email = sc.nextLine();

                dao.updateStudent(id, name, age, course, email);
            }

            else if (choice == 5) {

                System.out.println("Thank You");
            }

            else {

                System.out.println("Invalid Choice");
            }

        } while (choice != 5);

        sc.close();
    }
}