package POTD;

//You are given an array of events where events[i] = [startDayi, endDayi]. Every event i starts at startDayi and ends at endDayi.
//You can attend an event i at any day d where startTimei <= d <= endTimei. You can only attend one event at any time d.
//Return the maximum number of events you can attend.

//Example 1:
//Input: events = [[1,2],[2,3],[3,4]]
//Output: 3
//Explanation: You can attend all the three events.
//One way to attend them all is as shown.
//Attend the first event on day 1.
//Attend the second event on day 2.
//Attend the third event on day 3.

//Example 2:
//Input: events= [[1,2],[2,3],[3,4],[1,2]]
//Output: 4

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Event{
    int startTime;
    int endTime;
    Event(int start,int end){
        this.startTime = start;
        this.endTime = end;
    }
}

public class MaxNumberOfEventsThatCanBeAttended {
    public static void main(String[] args) {
        Event[] events = {new Event(1,2),new Event(2,3),new Event(3,4),new Event(1,2)};
        int[][] eventsArray = {{1,2},{2,3},{3,4},{1,2}};
        System.out.println(maxEvents(events));
        System.out.println(maxEvents2(eventsArray));
    }

    private static int maxEvents(Event[] events) {
        Arrays.sort(events, (a1,a2)-> {
            if(a1.startTime != a2.startTime){
                return a1.startTime - a2.startTime;
            }
            return a1.endTime - a2.endTime;
        });

        int maxDay = 0;
        for (Event e : events) {
            maxDay = Math.max(maxDay, e.endTime);
        }

        boolean[] occupied = new boolean[maxDay + 1];

        int count = 0;
        for (Event event : events) {
            for (int d = event.startTime; d <= event.endTime; d++) {
                if (!occupied[d]) {
                    occupied[d] = true;
                    count++;
                    break;
                }
            }
        }

        return count;
    }

    private static int maxEvents2(int[][] events){
        int maxDay = 0;
        for (int[] event : events) {
            maxDay = Math.max(maxDay, event[1]);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(events, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        int ans = 0;
        for (int i = 1, j = 0; i <= maxDay; i++) {
            while (j < events.length && events[j][0] <= i) {
                pq.offer(events[j][1]);
                j++;
            }
            while (!pq.isEmpty() && pq.peek() < i) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                pq.poll();
                ans++;
            }
        }

        return ans;
    }
}
