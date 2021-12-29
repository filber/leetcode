import java.util.List;

//TOPICS:
//[Graph],[Depth-First Search]
public class _841_KeysAndRooms {

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        int[] marks = new int[n];

        dfs(rooms,0,rooms.get(0),marks);
        for (int mark:marks) {
            if (mark==0) {
                return false;
            }
        }
        return true;
    }

    private static void dfs(List<List<Integer>> rooms, int room, List<Integer> keys, int[] marks) {
        if (marks[room]!=0) {
            return;
        }
        marks[room] = 1;
        for (int key : keys) {
            dfs(rooms, key, rooms.get(key), marks);
        }
    }

    public static void main(String[] args) {

    }
}
