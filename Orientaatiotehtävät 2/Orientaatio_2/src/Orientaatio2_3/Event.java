package Orientaatio2_3;

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

    public enum EventType{
        arrival, exit
    }

    public static class EventTypes {
        EventType eventType;

        public EventTypes(EventType eventType){
            this.eventType = eventType;
        }

        public void showEventType() {
            switch(eventType) {
                case arrival:
                    System.out.println("Event: arrival");
                    break;
                
                case exit:
                    System.out.println("Event: exit");
                    break;
                
                default:
                    System.out.println("No events");
                    break;
            }
        }
    }
}
