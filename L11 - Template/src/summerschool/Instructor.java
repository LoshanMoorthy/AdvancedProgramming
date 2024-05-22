package summerschool;

import java.util.Observable;
import java.util.Observer;

public class Instructor implements Observer {
    private String room;
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Course) {
            Course course = (Course) o;
            String changeType = (String) arg;
            switch (changeType) {
                case "title":
                    System.out.println("Instructor notified: Course title changed to " + course.getTitle());
                    break;
                case "room":
                    System.out.println("Instructor notified: Course room changed to " + course.getRoom());
                    this.room = course.getRoom();
                    break;
                case "date":
                    System.out.println("Instructor notified: Course date changed to " + course.getDate());
                    break;
                case "startTime":
                    System.out.println("Instructor notified: Course start time changed to " + course.getStartTime());
                    break;
                case "endTime":
                    System.out.println("Instructor notified: Course end time changed to " + course.getEndTime());
                    break;
            }
        }
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
