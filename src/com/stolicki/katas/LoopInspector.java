package com.stolicki.katas;

public class LoopInspector {

    public int loopSize(Node node) {
        if (node == null || node.getNext() == null) {
            return 0;
        }
        Node slowNode = node;
        Node fastNode = node;

        while (true) {
            slowNode = slowNode.getNext();
            fastNode = fastNode.getNext().getNext();
            if (slowNode == fastNode) {
                slowNode = node;
                while (slowNode != fastNode) {
                    slowNode = slowNode.getNext().getNext();
                    fastNode = fastNode.getNext();
                }
                int i = 1;
                fastNode = fastNode.getNext();
                while (slowNode != fastNode) {
                    fastNode = fastNode.getNext();
                    i++;
                }
                return i;
            }
        }
    }
    private static class Node {
        private final int value;
        private final Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node getNext() {
            return next;
        }

        public int getValue() {
            return value;
        }
    }
}
