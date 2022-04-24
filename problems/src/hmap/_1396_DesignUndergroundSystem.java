package hmap;

//https://leetcode.com/problems/design-underground-system/

import java.util.HashMap;
import java.util.Map;

public class _1396_DesignUndergroundSystem {

    public class UndergroundSystem {

        Map<Integer, Object[]> passengerMap = new HashMap<>();
        Map<String, double[]> stationMap = new HashMap<>();

        public UndergroundSystem() {

        }

        public void checkIn(int id, String stationName, int t) {
            passengerMap.put(id, new Object[]{stationName, t});
        }

        public void checkOut(int id, String arriveStation, int arriveTime) {
            Object[] pInfo = passengerMap.get(id);
            String fromStation = (String) pInfo[0];
            Integer fromTime = (Integer) pInfo[1];
            int costTime = arriveTime - fromTime;

            double[] sInfo = stationMap.computeIfAbsent(fromStation + "#" + arriveStation, k -> new double[]{0, 0});
            double cnt = sInfo[0];
            double average = sInfo[1];
            average = (cnt * average + costTime) / (cnt + 1);
            sInfo[0] = cnt + 1;
            sInfo[1] = average;
        }

        public double getAverageTime(String startStation, String endStation) {
            return stationMap.get(startStation + "#" + endStation)[1];
        }
    }
}
