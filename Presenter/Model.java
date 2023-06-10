package org.example.lesson5.Presenter;

import org.example.lesson5.Model.Table;

import java.util.Collection;
import java.util.Date;

public interface Model {
    Collection<Table> loadTables();

    /**
     * Бронирование столика
     * @param reservationDate Дата бронирования
     * @param tableNo Номер столика
     * @param name Имя клиента
     */
    int reservationTable(Date reservationDate, int tableNo, String name);

    /**
     * Отмена бронирования столика
     *
     * @param reservationID Номер брони
     * @return
     */
    boolean undoReservation(int reservationID);

//    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name);
}
