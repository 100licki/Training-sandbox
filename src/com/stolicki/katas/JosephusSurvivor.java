package com.stolicki.katas;

import java.util.LinkedList;
import java.util.List;

public class JosephusSurvivor {

    public static void main(String[] args) {
        System.out.println(josephusSurvivor(5, 3));
    }

    public static int josephusSurvivor(final int n, final int k) {
        List<Integer> circle = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            circle.add(i);
        }
        int pointer = k - 1;
        while (circle.size() != 1) {
            if (pointer >= circle.size()) {
                pointer %= circle.size();
            }
            for (int i = pointer; i < circle.size(); i += k - 1) {
                circle.remove(i);
                pointer += k - 1;
                if (circle.size() == 1) {
                    return circle.get(0);
                }
            }
        }
        return circle.get(0);
    }
}
