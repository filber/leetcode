package graph;

//https://leetcode.com/problems/evaluate-division/

import java.util.*;

public class _399_EvaluateDivision {

    Map<String, Map<String, Double>> graph = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < values.length; i++) {
            List<String> equation = equations.get(i);
            String numerator = equation.get(0);
            String dominator = equation.get(1);
            double val = values[i];
            Map<String, Double> numeratorEdges = graph.computeIfAbsent(numerator, k -> new HashMap<>());
            numeratorEdges.put(dominator, val);
            Map<String, Double> dominatorEdges = graph.computeIfAbsent(dominator, k -> new HashMap<>());
            dominatorEdges.put(numerator, 1 / val);
        }

        int n = queries.size();
        double[] ans = new double[n];

        for (int i = 0; i < n; i++) {
            List<String> query = queries.get(i);
            String numerator = query.get(0);
            String dominator = query.get(1);
            if (!graph.containsKey(numerator) || !graph.containsKey(dominator)) {
                ans[i] = -1;
            } else if (numerator.equals(dominator)) {
                ans[i] = 1;
            } else {
                Set<String> visited = new HashSet<>();
                ans[i] = dfs(visited, numerator, dominator, 1.0);
            }
        }
        return ans;
    }

    private double dfs(Set<String> visited, String numerator, String dominator, double val) {
        if (visited.contains(numerator)) {
            return -1;
        }
        visited.add(numerator);
        Map<String, Double> edges = graph.get(numerator);
        double weight = edges.getOrDefault(dominator, 0.0);
        if (weight != 0) {
            return weight * val;
        }

        for (Map.Entry<String, Double> entry : edges.entrySet()) {
            double rst = dfs(visited, entry.getKey(), dominator, val * entry.getValue());
            if (rst != -1.0) {
                return rst;
            }
        }
        return -1.0;
    }
}
