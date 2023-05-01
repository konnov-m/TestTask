package org.example;

import org.junit.Assert;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;


class MainTest {

    @Test()
    @RepeatedTest(10_000)
    void main() {
        LinkedList<Integer> list = new LinkedList<>();
        Random random = new Random();

        for (int i = 0; i < 1_000; i++) {
            list.add(random.nextInt(0, 10));
        }

        Main.main(list);

    }

    static int sum (List<Integer> list) {
        int s = 0;
        for (int i = 0; i < list.size(); i++) {
            s += list.get(i);
        }
        return s;
    }


}