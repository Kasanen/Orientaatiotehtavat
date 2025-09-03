package Orientaatio2_3;

import Orientaatio2_3.Event.EventType;
import Orientaatio2_3.Event.EventTypes;

public class EventTest {

    public static void main(String[] args) {
        EventList eventList = new EventList();

        eventList.addEvent(new Event(10));
        eventList.addEvent(new Event(5));
        eventList.addEvent(new Event(20));
        eventList.addEvent(new Event(15));

        EventTypes arrivalType = new EventTypes(EventType.arrival);
        arrivalType.showEventType();

        EventTypes exitType = new EventTypes(EventType.exit);
        exitType.showEventType();

        Event next = eventList.getNexEvent();
        System.out.println("Next event: " + next);

        System.out.println("Remaining events in order:");
        for (Event e : eventList.getEventsInOrder()) {
            System.out.println(e);
        }
    }
}
