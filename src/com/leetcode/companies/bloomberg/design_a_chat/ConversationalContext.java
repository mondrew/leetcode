package com.leetcode.companies.bloomberg.design_a_chat;

import java.util.*;

public class ConversationalContext {

    public class IMPost {

        public Long timestamp;
        public String chatroomId;
        public String senderId;
        public String messageText;

        public IMPost(Long timestamp, String chatroomId, String senderId, String messageText) {
            this.timestamp = timestamp;
            this.chatroomId = chatroomId;
            this.senderId = senderId;
            this.messageText = messageText;
        }
    }

    /**
     *
     * @param posts      List of posts across all chat rooms
     * @param senderId   Sender's id (String with sender's name)
     * @param windowSize Context size (amount of messages before / after the sender's message)
     * @return List of all conversations
     */
    public List<List<IMPost>> getConversationalContext(List<IMPost> posts, String senderId, int windowSize) {
        List<List<IMPost>> result = new ArrayList<>();
        int dequeSize = windowSize * 2 + 1; // context before + context after
        if (posts.size() < dequeSize) {
            return null;
        }
        Deque<IMPost> deque = new ArrayDeque<>(posts.subList(0, dequeSize - 1));
        int mid = windowSize;
        for (int i = dequeSize - 1; i < posts.size(); i++) {
            deque.push(posts.get(i));
            List<IMPost> list = new ArrayList<>(deque);
            if (list.get(mid).senderId.equals(senderId)) {
                result.add(new ArrayList<>(deque));
            }
            deque.poll();
        }
        return result;
    }
}