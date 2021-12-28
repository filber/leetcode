public class _852_PeakIndexInAMountainArray {
    public static int peakIndexInMountainArray(int[] arr) {
        int peakIndex = findPeak(arr, 1, arr.length - 2);
        System.out.println(peakIndex);
        return peakIndex;
    }

    public static int findPeak(int[] arr, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return startIndex;
        }
        int middleIndex = (startIndex + endIndex) / 2;
        int middleValue = arr[middleIndex];
        int leftValue = arr[middleIndex-1];
        int rightValue = arr[middleIndex+1];
        if (leftValue>middleValue) {
            return findPeak(arr, startIndex, middleIndex - 1);
        } else if (rightValue>middleValue) {
            return findPeak(arr,middleIndex+1,endIndex);
        } else {
            return middleIndex;
        }
    }

    public static void main(String[] args) {
//        Input: arr = [0,1,0]
//        Output: 1
        peakIndexInMountainArray(new int[]{0, 1, 0});

//        Input: arr = [0,2,1,0]
//        Output: 1
        peakIndexInMountainArray(new int[]{0, 2, 1, 0});

//        Input: arr = [0,10,5,2]
//        Output: 1
        peakIndexInMountainArray(new int[]{0, 10, 5, 2});

//        Input: arr = [3,4,5,1]
//        Output: 2
        peakIndexInMountainArray(new int[]{3, 4, 5, 1});

//        Input: arr = [24,69,100,99,79,78,67,36,26,19]
//        Output: 2
        peakIndexInMountainArray(new int[]{24, 69, 100, 99, 79, 78, 67, 36, 26, 19});
    }
}
