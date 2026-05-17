import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeManager {

    static ArrayList<String> names = new ArrayList<>();
    static ArrayList<Double> grades = new ArrayList<>();

    public static void addStudent(String name, double grade) {
        names.add(name);
        grades.add(grade);
        System.out.println("✓ Student added: " + name + " | Grade: " + grade);
    }

    public static void showAll() {
        if (names.isEmpty()) {
            System.out.println("No students yet.");
            return;
        }
        System.out.println("\n--- Student List ---");
        for (int i = 0; i < names.size(); i++) {
            System.out.println((i + 1) + ". " + names.get(i) + " → " + grades.get(i) + " (" + getLetter(grades.get(i)) + ")");
        }
    }

    public static String getLetter(double grade) {
        if (grade >= 90) return "A";
        else if (grade >= 80) return "B";
        else if (grade >= 70) return "C";
        else if (grade >= 60) return "D";
        else return "F";
    }

    public static void showAverage() {
        if (grades.isEmpty()) {
            System.out.println("No grades yet.");
            return;
        }
        double sum = 0;
        for (double g : grades) sum += g;
        System.out.println("Class Average: " + sum / grades.size());
    }

    public static void showHighest() {
        if (grades.isEmpty()) return;
        double max = grades.get(0);
        String topStudent = names.get(0);
        for (int i = 1; i < grades.size(); i++) {
            if (grades.get(i) > max) {
                max = grades.get(i);
                topStudent = names.get(i);
            }
        }
        System.out.println("Top Student: " + topStudent + " → " + max);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Grade Manager ===");
            System.out.println("1. Add Student");
            System.out.println("2. Show All Students");
            System.out.println("3. Show Class Average");
            System.out.println("4. Show Top Student");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            if (choice == 5) {
                System.out.println("Goodbye!");
                break;
            }
            switch (choice) {
                case 1:
                    System.out.print("Student name: ");
                    String name = sc.next();
                    System.out.print("Grade (0-100): ");
                    double grade = sc.nextDouble();
                    addStudent(name, grade);
                    break;
                case 2: showAll(); break;
                case 3: showAverage(); break;
                case 4: showHighest(); break;
                default: System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }
}
