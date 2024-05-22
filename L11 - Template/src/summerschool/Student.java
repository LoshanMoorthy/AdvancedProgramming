package summerschool;

import java.util.Observable;
import java.util.Observer;

public class Student implements Observer {
    private int[] teachingDays = new int[5];
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Course) {
            Course course = (Course) o;
            String changeType = (String) arg;
            switch (changeType) {
                case "title" ->
                        System.out.println("Student notified: Course title changed to " + course.getTitle());
                case "room" ->
                        System.out.println("Student notified: Course room changed to " + course.getRoom());
                case "date" ->
                        System.out.println("Student notified: Course date changed to " + course.getDate());
                case "startTime" ->
                        System.out.println("Student notified: Course start time changed to " + course.getStartTime());
                case "endTime" ->
                        System.out.println("Student notified: Course end time changed to " + course.getEndTime());
            }
        }
    }
}
