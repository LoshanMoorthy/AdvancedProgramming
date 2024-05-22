package summerschool;

import java.util.Observer;
import java.util.Observable;

public class Janitor implements Observer {
    private String endOfDay;

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Course) {
            Course course = (Course) o;
            String changeType = (String) arg;
            switch (changeType) {
                case "title":
                    System.out.println("Janitor notified: Course title changed to " + course.getTitle());
                    break;
                case "room":
                    System.out.println("Janitor notified: Course room changed to " + course.getRoom());
                    break;
                case "date":
                    System.out.println("Janitor notified: Course date changed to " + course.getDate());
                    break;
                case "startTime":
                    System.out.println("Janitor notified: Course start time changed to " + course.getStartTime());
                    break;
                case "endTime":
                    System.out.println("Janitor notified: Course end time changed to " + course.getEndTime());
                    this.endOfDay = course.getEndTime();
                    break;
            }
        }
    }

    public String getEndOfDay() {
        return endOfDay;
    }

    public void setEndOfDay(String endOfDay) {
        this.endOfDay = endOfDay;
    }
}
