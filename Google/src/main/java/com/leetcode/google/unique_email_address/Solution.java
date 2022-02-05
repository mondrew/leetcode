package com.leetcode.google.unique_email_address;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String s : emails) {
            String[] parts = s.split("@");
            parts[0] = parts[0].replace(".", "");
            if (parts[0].contains("+")) {
                parts[0] = parts[0].substring(0, parts[0].indexOf("+"));
            }
            set.add(parts[0] + "@" + parts[1]);
        }
        return set.size();
    }

    public static void main(String[] args) {
        String[] emails = new String[5];
        emails[0] = "tata.tutu+ueir@gmail.com";
        emails[1] = "ewf.ewfwef+tutu+ueir@gmail.com";
        emails[2] = "riri+ewf.ewfwef+tutu+ueir@gmail.com";
        emails[3] = "tatatutu@gmail.com";
        emails[4] = "riri@gmail.com";
        int res = numUniqueEmails(emails);
        System.out.println(res);
    }
}
