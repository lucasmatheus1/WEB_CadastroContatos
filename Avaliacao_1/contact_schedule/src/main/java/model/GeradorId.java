package model;

import java.util.concurrent.atomic.AtomicInteger;

public class GeradorId {
    private static final AtomicInteger counter = new AtomicInteger();

    public static int getId() {
        return counter.getAndIncrement();
    }
}