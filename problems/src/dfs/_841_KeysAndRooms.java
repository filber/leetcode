package dfs;

// https://leetcode.com/problems/keys-and-rooms/
import java.util.ArrayList;
import java.util.List;

//TOPICS:
//[Graph],[Depth-First Search]
public class _841_KeysAndRooms {

    int cnt = 0;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        dfs(rooms,visited,0);
        return cnt == n;
    }

    private void dfs(List<List<Integer>> rooms, boolean[] visited, int i) {
        if (visited[i]) {
            return;
        }
        visited[i] = true;
        cnt++;
        for (int j : rooms.get(i)) {
            dfs(rooms, visited, j);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> r1 = new ArrayList<>();
        List<Integer> r1_1 = new ArrayList<>();
        r1_1.add(1);
        r1.add(r1_1);
        List<Integer> r1_2 = new ArrayList<>();
        r1_2.add(2);
        r1.add(r1_2);
        List<Integer> r1_3 = new ArrayList<>();
        r1_3.add(3);
        r1.add(r1_3);
        List<Integer> r1_4 = new ArrayList<>();
        r1.add(r1_4);
        boolean c1 = new _841_KeysAndRooms().canVisitAllRooms(r1);

        List<List<Integer>> r2 = new ArrayList<>();
        List<Integer> r2_1 = new ArrayList<>();
        r2_1.add(1);
        r2_1.add(3);
        r2.add(r2_1);
        List<Integer> r2_2 = new ArrayList<>();
        r2_2.add(3);
        r2_2.add(0);
        r2_2.add(1);
        r2.add(r2_2);
        List<Integer> r2_3 = new ArrayList<>();
        r2_3.add(2);
        r2.add(r2_3);
        List<Integer> r2_4 = new ArrayList<>();
        r2_4.add(0);
        r2.add(r2_4);
        boolean c2 = new _841_KeysAndRooms().canVisitAllRooms(r2);
    }
}
