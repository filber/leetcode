import java.util.ArrayList;
import java.util.List;

//TOPICS:
//[Graph]
public class _1557_MinimumNumberOfVerticesToReachAllNodes {
    public static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] indegree = new int[n];
        for (List<Integer> edge : edges) {
            int to  = edge.get(1);
            indegree[to]++;
        }

        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (indegree[i]==0) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> e1 = new ArrayList<>();
        List<Integer> e1_1 = new ArrayList<>();
        e1.add(e1_1);
        e1_1.add(0);
        e1_1.add(1);
        List<Integer> e1_2 = new ArrayList<>();
        e1.add(e1_2);
        e1_2.add(0);
        e1_2.add(2);
        List<Integer> e1_3 = new ArrayList<>();
        e1.add(e1_3);
        e1_3.add(2);
        e1_3.add(5);
        List<Integer> e1_4 = new ArrayList<>();
        e1.add(e1_4);
        e1_4.add(3);
        e1_4.add(4);
        List<Integer> e1_5 = new ArrayList<>();
        e1.add(e1_5);
        e1_5.add(4);
        e1_5.add(2);

        List<Integer> v1 = findSmallestSetOfVertices(6, e1);
    }
}
