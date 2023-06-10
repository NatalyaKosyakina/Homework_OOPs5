package org.example.lesson5.Model;

import java.util.Date;

public class Reservation {

    private static int counter = 9000;
    private final int id;

    private Date date;
    private String name;
    private boolean actual;

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    {
        id = ++counter;
    }

    public Reservation(Date date, String name) {
        this.date = date;
        this.name = name;
        this.actual = true;
    }

    public boolean isActual() {
        return actual;
    }

    public void setActual(boolean actual) {
        this.actual = actual;
    }
}
