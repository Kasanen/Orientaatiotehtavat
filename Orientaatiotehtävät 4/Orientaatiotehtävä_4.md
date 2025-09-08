# Orientaatiotehtävä 4
1.  
I would make an example case of job simulator.  

Arrival count = count of job seekers. 

Completed count = amount of workers that completed their job.

Busy time = time spent at work or job.

Time = total simulation time.

2.  
Maintained = continously tracked system state 
“Directly observable variables” 

Updated = incremented / adjusted at events 
“Derived variables” 

Computed = derived after the run from the above 
“Additional directly observable variables”

3. 
![House guard](<Screenshot from 2025-09-08 17-05-41.png>)
![Airport passanger processing](<Screenshot from 2025-09-08 17-05-50.png>)

4. Code is in 3 phases. From A to C

```java
public void runSimulation() {
    double clock = 0;
    initializeEventList();

    while (!finished()) {
        // --- Phase A: Advance clock ---
        clock = nextEventTime();

        // --- Phase B: Execute events at this time ---
        executeEventsAt(clock);

        // --- Phase C: Execute conditional activities ---
        while (anyActivitiesEnabled()) {
            executeEnabledActivities();
        }
    }

    printResults();
}
```
5. 
#### A-phase coding
Moving the simulation clock to the time of the next scheduled event.
#### B-events
Executing all unconditional events scheduled exactly at the current simulation time.
#### C-events
Repeatedly executing any conditional activities that are enabled immediately by the current system state, until there's nothing remaining.