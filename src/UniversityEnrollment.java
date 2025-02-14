import java.util.HashMap;
import java.util.Scanner;

class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}

class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) {
        super(message);
    }
}

public class UniversityEnrollment {
    private static final int COURSE_CAPACITY = 2;
    private static int enrolledStudents = 0;
    private static final HashMap<String, Boolean> prerequisites = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Simulating a prerequisite completion status
        prerequisites.put("Core Java", false);

        try {
            System.out.print("Enroll in Course: ");
            String course = scanner.nextLine();

            System.out.print("Prerequisite: ");
            String prerequisite = scanner.nextLine();

            if (!prerequisites.getOrDefault(prerequisite, false)) {
                throw new PrerequisiteNotMetException("Error: PrerequisiteNotMetException - Complete " + prerequisite + " before enrolling in " + course);
            }

            if (enrolledStudents >= COURSE_CAPACITY) {
                throw new CourseFullException("Error: CourseFullException - The course " + course + " is full.");
            }

            enrolledStudents++;
            System.out.println("Enrollment successful in " + course);

        } catch (PrerequisiteNotMetException | CourseFullException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid input.");
        } finally {
            scanner.close();
        }
    }
}
