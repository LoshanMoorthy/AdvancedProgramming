package summerschool;

public class SummerSchool {

    public static void main(String[] args) {
        Course course = new Course("Software Development", "Room 101", "2024-06-01", "09:00", "17:00");

        Student student = new Student();
        Instructor instructor = new Instructor();
        Janitor janitor = new Janitor();

        course.addObserver(student);
        course.addObserver(instructor);
        course.addObserver(janitor);

        course.setTitle("Advanced Software Development");
        course.setRoom("Room 202");
        course.setDate("2024-06-02");
        course.setStartTime("10:00");
        course.setEndTime("18:00");
    }
}
