package org.example.lesson5.Presenter;

import java.util.Date;

public interface ViewObserver {

    void onReservationTable(Date orderDate, int tableNo, String name);

    void undoReservation(int reservationID);

    void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name);
}
