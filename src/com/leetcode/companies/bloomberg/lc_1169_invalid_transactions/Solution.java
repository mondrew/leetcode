package com.leetcode.companies.bloomberg.lc_1169_invalid_transactions;

import java.util.*;

class Solution {

    static class Transaction {

        public String name;
        public int time;
        public int amount;
        public String city;
        public boolean isValid;

        public Transaction(String name, int time, int amount, String city, boolean isValid) {
            this.name = name;
            this.time = time;
            this.amount = amount;
            this.city = city;
            this.isValid = isValid;
        }
    }

    public static List<String> invalidTransactions(String[] transactions) {
        Set<String> possiblyInvalidTransactions = new HashSet<>();
        Map<String, List<Transaction>> map = new HashMap<>();
        for (String transaction : transactions) {
            String[] array = transaction.split(",");
            List<Transaction> list = null;
            if (map.containsKey(array[0])) {
                list = map.get(array[0]);
            } else {
                list = new ArrayList<>();
                map.put(array[0], list);
            }
            Transaction newTransaction = new Transaction(array[0],
                    Integer.parseInt(array[1]),
                    Integer.parseInt(array[2]),
                    array[3],
                    true);
            list.add(newTransaction);
            if (Integer.parseInt(array[2]) > 1000) {
                possiblyInvalidTransactions.add(transaction);
                newTransaction.isValid = false;
            }
        }
        for (Map.Entry<String, List<Transaction>> e : map.entrySet()) {
            List<Transaction> transactionList = e.getValue();
            transactionList.sort(Comparator.comparingInt(t -> t.time));
            for (int i = 0; i < transactionList.size(); i++) {
                for (int j = i + 1; j < transactionList.size(); j++) {
                    if (Math.abs(transactionList.get(i).time - transactionList.get(j).time) <= 60 &&
                            !transactionList.get(i).city.equals(transactionList.get(j).city)) {
                        transactionList.get(i).isValid = false;
                        transactionList.get(j).isValid = false;
                    }
                }
            }
        }
        List<String> result = map.values().stream()
                .flatMap(List::stream)
                .filter(t -> !t.isValid)
                .map(t -> t.name + "," + t.time + "," + t.amount + "," + t.city)
                .toList();
        return result;
    }

    public static void main(String[] args) {
        String[] request = {"alice,20,800,mtv","alice,50,100,beijing"};
        invalidTransactions(request);
    }
}