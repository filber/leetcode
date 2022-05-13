package hmap;

//https://leetcode.com/problems/design-underground-system/

import java.util.HashMap;
import java.util.Map;

public class _1396_DesignUndergroundSystem {

    public class UndergroundSystem {

        class CheckIn {
            String startStation;
            int startTime;

            public CheckIn(String station, int time) {
                startStation = station;
                startTime = time;
            }
        }

        class Trace {
            int cnt;
            double avg;

            public Trace(int c, double a) {
                cnt = c;
                avg = a;
            }
        }

        Map<Integer, CheckIn> pMap = new HashMap<>();
        Map<String, Trace> sMap = new HashMap<>();

        public UndergroundSystem() {
        }

        public void checkIn(int id, String startStation, int startTime) {
            pMap.put(id, new CheckIn(startStation, startTime));
        }

        public void checkOut(int id, String arriveStation, int arriveTime) {
            CheckIn checkIn = pMap.remove(id);
            int time = arriveTime - checkIn.startTime;
            Trace trace = sMap.computeIfAbsent(checkIn.startStation + "#" + arriveStation, k -> new Trace(0, 0));
            trace.avg = (trace.avg * trace.cnt + time) / (trace.cnt + 1);
            trace.cnt++;
        }

        public double getAverageTime(String startStation, String endStation) {
            String key = startStation + "#" + endStation;
            Trace trace = sMap.get(key);
            return trace.avg;
        }
    }
}
