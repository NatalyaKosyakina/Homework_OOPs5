package org.example.lesson5.Model;

import org.example.lesson5.Presenter.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TableModel implements Model {

    private Collection<Table> tables;

    /**
     * Получить все столики
     * @return
     */
    public Collection<Table> loadTables(){
        if (tables == null)
        {
            tables = new ArrayList<>();

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());

        }

        return tables;
    }

    /**
     * Бронирование столика
     * @param reservationDate Дата бронирования
     * @param tableNo Номер столика
     * @param name Имя клиента
     */
    public int reservationTable(Date reservationDate, int tableNo, String name){
        for (Table table: tables) {
            if (table.getNo() == tableNo){
                Reservation reservation = new Reservation(reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        throw new RuntimeException("Некорректный номер столика.");
    }

    /**
     * Отмена бронирования столика
     *
     * @param reservationID Номер брони
     * @return
     */
    @Override
    public boolean undoReservation(int reservationID) {
        boolean success = false;
        for (Table table: tables) {
            if ((table.getReservation(reservationID) !=  null) && (table.getReservation(reservationID).isActual())){
                table.getReservation(reservationID).setActual(false);
                success =  true;
            }
        }
        return success;
    }

//    /**
//     * TODO: Разработать самостоятельно в рамках домашней работы
//     * Поменять бронь столика
//     */
//    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name){
//        undoReservation(oldReservation);
//        return reservationTable(reservationDate, tableNo, name);
//    }
}
