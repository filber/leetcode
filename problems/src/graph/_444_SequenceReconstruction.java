package graph;

//https://leetcode.com/problems/sequence-reconstruction/

import java.util.*;

public class _444_SequenceReconstruction {
//    Check whether the original sequence org can be uniquely reconstructed from the sequences in seqs.
//    The org sequence is a permutation of the integers from 1 to n, with 1 ≤ n ≤ 10^4.
//    Reconstruction means building a shortest common supersequence of the sequences in seqs
//    (i.e., a shortest sequence so that all sequences in seqs are subsequences of it).
//    Determine whether there is only one sequence that can be reconstructed from seqs and it is the org sequence.

    boolean sequenceReconstruction(int[] pSeq, int[][] seqs) {
        // 1. Construct Graph using edges from seqs
        // target -> {sources}
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> outDegree = new HashMap<>();
        for (int[] seq : seqs) {
            for (int i = 0; i < seq.length - 1; i++) {
                int source = seq[i];
                int target = seq[i + 1];
                Set<Integer> targetSet = graph.computeIfAbsent(target, k -> new HashSet<>());
                if (!targetSet.contains(source)) {
                    targetSet.add(source);
                    outDegree.put(source, outDegree.getOrDefault(source, 0) + 1);
                }
                graph.computeIfAbsent(source, k -> new HashSet<>());
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int node : graph.keySet()) {
            if (!outDegree.containsKey(node)) {
                queue.add(node);
            }
        }

        // 2. Check Exceptions
        if (graph.keySet().size() != pSeq.length) {
            return false;
        } else if (queue.size() != 1) {
            return false;
        }


        // 3. Continuously traverse from node with OutDegree = 0
        int[] traverseSeq = new int[pSeq.length];
        int idx = traverseSeq.length - 1;
        while (!queue.isEmpty()) {
            if (queue.size() > 1) {
                return false; // multiple choices
            }
            int node = queue.poll();
            traverseSeq[idx--] = node;
            for (int adj : graph.get(node)) {
                int out = outDegree.get(adj);
                outDegree.put(adj, out - 1);
                if (out == 1) {
                    queue.add(adj);
                }
            }
        }

        // 4. Compare traverseOrder with pSeq

        return Arrays.compare(traverseSeq, pSeq) == 0;
    }
}
