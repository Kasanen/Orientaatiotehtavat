package Orientaatio2_2;

public class Event implements Comparable<Event> {

    private int eventTime;

    public Event(int eventTime) {
        this.eventTime = eventTime;
    }

    public int getEventTime() {
        return eventTime;
    }

    @Override
    public int compareTo(Event other){
        return Integer.compare(this.eventTime, other.eventTime);
    }

    @Override
    public String toString() {
        return "Event{eventTime=" + eventTime + "}";
    }
}
