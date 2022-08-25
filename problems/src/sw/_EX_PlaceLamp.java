package sw;

public class _EX_PlaceLamp {

    int placeLamp(int[] objects, int radius) {
        int l = 0;
        int wl;
        int maxObjects = 0;
        int diameter = 2 * radius;
        int pos = objects[0] - radius;
        for (int r = 0; r < objects.length; r++) {
            wl = objects[r] - objects[l];
            while (wl > diameter) {
                l++;
                wl = objects[r] - objects[l];
            }
            int obj = r - l + 1;
            if (obj > maxObjects) {
                maxObjects = obj;
                pos = objects[r] - radius;
            }
        }

        return pos;
    }
}
