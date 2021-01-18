public class _1710_MaximumUnitsOnATruck {

//  Input: boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
//  Output: 8

//  Input: boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
//  Output: 91

  public static int maximumUnits(int[][] boxTypes, int truckSize) {
    int[] unitCount = new int[1001];
    int largestUnit = Integer.MIN_VALUE;
    int smallestUnit = Integer.MAX_VALUE;

    for (int i = 0; i < boxTypes.length; i++) {
      int count = boxTypes[i][0];
      int unit = boxTypes[i][1];
      unitCount[unit] += count;
      if (unit < smallestUnit) {
        smallestUnit = unit;
      }
      if (unit > largestUnit) {
        largestUnit = unit;
      }
    }

    int remainTruckSize = truckSize;
    int totalUnit = 0;
    for (int unit = largestUnit; unit >= smallestUnit && remainTruckSize > 0; unit--) {
      int count = unitCount[unit];
      if (remainTruckSize >= count) {
        totalUnit += count * unit;
        remainTruckSize -= count;
      } else {
        totalUnit += remainTruckSize * unit;
        remainTruckSize = 0;
      }
    }
    return totalUnit;
  }

  public static void main(String[] args) {
//    int[][] boxTypes = {{1,3},{2,2},{3,1}};
//    int maximumUnits = maximumUnits(boxTypes,4);

    int[][] boxTypes = {{5,10},{2,5},{4,7},{3,9}};
    int maximumUnits = maximumUnits(boxTypes,10);

  }
}
