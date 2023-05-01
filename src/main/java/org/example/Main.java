package org.example;

import java.util.LinkedList;
import java.util.Random;

public class Main {
    public static void main(LinkedList<Integer> list) {
        CustomThread c1 = new CustomThread(list,true, "Thread-1");
        CustomThread c2 = new CustomThread(list, false, "Thread-0");

        Thread customThread1 = new Thread(c1);
        Thread customThread2 = new Thread(c2);

        customThread1.start();
        customThread2.start();

        try {
            customThread1.join();
            customThread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        Random random = new Random();


        for (int i = 0; i < 100; i++) {
            list.add(random.nextInt(0, 10));
        }

        System.out.println(Integer.toBinaryString(7).chars().filter(c -> c == '1').count());


    }



}