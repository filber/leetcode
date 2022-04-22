package graph;

//https://leetcode.com/problems/sequence-reconstruction/

import java.util.*;

public class _444_SequenceReconstruction {
//    Check whether the original sequence org can be uniquely reconstructed from the sequences in seqs.
//    The org sequence is a permutation of the integers from 1 to n, with 1 ≤ n ≤ 10^4.
//    Reconstruction means building a shortest common supersequence of the sequences in seqs
//    (i.e., a shortest sequence so that all sequences in seqs are subsequences of it).
//    Determine whether there is only one sequence that can be reconstructed from seqs and it is the org sequence.

    boolean sequenceReconstruction(int[] org, int[][] seqs) {
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < seqs.length; i++) {
            int[] seq = seqs[i];
            for (int j = 0; j < seq.length - 1; j++) {
                int from = seq[j];
                int to = seq[j + 1];
                edges.add(new int[]{from, to});
            }
        }

        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            Set<Integer> set = graph.computeIfAbsent(from, k -> new HashSet<>());
            set.add(to);
            graph.computeIfAbsent(to, k -> new HashSet<>());
        }


        for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
            int from = entry.getKey();
            inDegree.computeIfAbsent(from, k -> 0);
            for (int to : entry.getValue()) {
                inDegree.put(to, inDegree.getOrDefault(to, 0) + 1);
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            int from = entry.getKey();
            int in = entry.getValue();
            if (in == 0) {
                queue.add(from);
                visited.add(from);
            }
        }

        int[] sequence = new int[inDegree.size()];
        if (org.length != sequence.length) {
            return false;
        }

        int idx = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (size > 1) {
                return false;
            }

            int from = queue.poll();
            sequence[idx++] = from;
            for (int to : graph.get(from)) {
                inDegree.put(to, inDegree.get(to) - 1);
                if (!visited.contains(to) && inDegree.get(to).equals(0)) {
                    visited.add(to);
                    queue.add(to);
                }
            }
        }

        return Arrays.compare(org, sequence) == 0;
    }
}
