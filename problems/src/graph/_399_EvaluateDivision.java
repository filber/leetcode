package graph;

//https://leetcode.com/problems/evaluate-division/

import java.util.*;

public class _399_EvaluateDivision {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = values.length;
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<String> equation = equations.get(i);
            double value = values[i];
            String numerator = equation.get(0);
            String dominator = equation.get(1);
            Map<String, Double> nMap = graph.computeIfAbsent(numerator, k -> new HashMap<>());
            nMap.put(dominator, value);
            Map<String, Double> dMap = graph.computeIfAbsent(dominator, k -> new HashMap<>());
            dMap.put(numerator, 1 / value);
        }

        double[] ans = new double[queries.size()];
        for (int i = 0; i < ans.length; i++) {
            List<String> query = queries.get(i);
            String numerator = query.get(0);
            String dominator = query.get(1);
            if (!graph.containsKey(numerator) || !graph.containsKey(dominator)) {
                ans[i] = -1;
            } else if (numerator.equals(dominator)) {
                ans[i] = 1;
            } else {
                Set<String> visited = new HashSet<>();
                ans[i] = dfs(graph, visited, numerator, dominator, 1);
            }
        }
        return ans;
    }

    private double dfs(Map<String, Map<String, Double>> graph, Set<String> visited, String numerator, String dominator, double val) {
        if (visited.contains(numerator)) {
            return -1;
        } else if (graph.get(numerator).containsKey(dominator)) {
            return val * graph.get(numerator).get(dominator);
        }
        visited.add(numerator);
        Map<String, Double> map = graph.get(numerator);
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            String d = entry.getKey();
            double v = entry.getValue();
            double rst = dfs(graph, visited, d, dominator, val * v);
            if (rst != -1) {
                return rst;
            }
        }

        return -1;
    }
}
