package Orientaatio2_2;

public class EventTest {

    public static void main(String[] args) {
        EventList eventList = new EventList();

        eventList.addEvent(new Event(2));
        eventList.addEvent(new Event(1));
        eventList.addEvent(new Event(4));
        eventList.addEvent(new Event(3));

        Event next = eventList.getNexEvent();
        System.out.println("Next event: " + next);

        System.out.println("Remaining events in order:");
        for (Event e : eventList.getEventsInOrder()) {
            System.out.println(e);
        }
    }
}
