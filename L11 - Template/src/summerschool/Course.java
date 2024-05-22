package summerschool;

import java.util.Observable;

public class Course extends Observable {
    private String title;
    private String room;
    private String date;
    private String starTime;
    private String endTime;

    public Course(String title, String room, String date, String starTime, String endTime) {
        this.title = title;
        this.room = room;
        this.date = date;
        this.starTime = starTime;
        this.endTime = endTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        setChanged();
        notifyObservers("title");
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
        setChanged();
        notifyObservers("room");
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
        setChanged();
        notifyObservers("date");
    }

    public String getStartTime() {
        return starTime;
    }

    public void setStartTime(String starTime) {
        this.starTime = starTime;
        setChanged();
        notifyObservers("startTime");
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
        setChanged();
        notifyObservers("endTime");
    }
}
