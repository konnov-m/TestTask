package org.example;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomThread implements Runnable{

    LinkedList<Integer> list;
    boolean direction; // false - left, true - right
    private int countOfElements;
    private int size;

    private final String name;

    public CustomThread(LinkedList<Integer> list, boolean direction, String name) {
        this.list = list;
        this.direction = direction;
        this.name = name;
        countOfElements = 0;
        size = 0;
    }

    @Override
    public void run() {
        while (list.size() != 0) {
            try {
                if (!direction) {
                    synchronized (list.getLast()) {
                        if (list.size() == 0) {
                            break;
                        }
                        countOfElements += countOfElements(list.getLast(), '1');
                        size += 1;
                        list.removeLast();
                    }
                } else {
                    synchronized (list.getFirst()) {
                        if (list.size() == 0) {
                            break;
                        }
                        countOfElements += countOfElements(list.getFirst(), '0');
                        size += 1;
                        list.removeFirst();
                    }
                }
            } catch (RuntimeException e) {
                break;
            }
        }
        if (!direction) {
            System.out.println(name + " size = " + size + " Count of 1 = " + countOfElements);
        } else {
            System.out.println(name + " size = " + size + " Count of 0 = " + countOfElements);
        }
    }

    private static int countOfElements(int num, char symbol) {
        return (int) Integer.toBinaryString(num).chars().filter(c -> c == symbol).count();
    }

}
