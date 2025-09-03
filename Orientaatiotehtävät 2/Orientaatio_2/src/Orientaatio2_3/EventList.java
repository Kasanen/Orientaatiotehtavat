package Orientaatio2_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class EventList {
    private PriorityQueue<Event> queue = new PriorityQueue<>();

    public void addEvent(Event event) {
        queue.add(event);
    }

    public Event getNexEvent() {
        return queue.poll();
    }

    public List<Event> getEventsInOrder() {
        List<Event> events = new ArrayList<>(queue);
        Collections.sort(events);
        return events;
    }
}
