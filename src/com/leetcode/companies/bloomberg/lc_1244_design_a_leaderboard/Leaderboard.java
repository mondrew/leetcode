package com.leetcode.companies.bloomberg.lc_1244_design_a_leaderboard;

import java.util.*;

public class Leaderboard {

    private Map<Integer, Integer> board;

    public Leaderboard() {
        board = new HashMap<>();
    }

    public void addScore(int playerId, int score) {
        int playerScore = board.getOrDefault(playerId, 0) + score;
        board.put(playerId, playerScore);
    }

    public int top(int K) {
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : this.board.entrySet()) {
            heap.offer(entry);
            if (heap.size() > K) {
                heap.poll();
            }
        }
        int topSum = 0;
        Iterator<Map.Entry<Integer, Integer>> iterator = heap.iterator();
        while (iterator.hasNext()) {
            topSum += iterator.next().getValue();
        }
        return topSum;
    }

    public void reset(int playerId) {
        board.put(playerId, 0);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */