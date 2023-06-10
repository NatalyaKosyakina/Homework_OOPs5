package org.example.lesson5.Presenter;

import org.example.lesson5.Model.Table;

import java.util.Collection;
import java.util.Date;

public class BookingPresenter implements ViewObserver {

    private final Model tableModel;
    private final View bookingView;
    public BookingPresenter(Model tableModel, View bookingView){
        this.tableModel = tableModel;
        this.bookingView = bookingView;
        bookingView.setObserver(this);
    }

    private Collection<Table> loadTables(){
        return tableModel.loadTables();
    }

    /**
     * Метод выводит список всех столиков
     */
    public void showTables(){
        bookingView.showTables(loadTables());
    }

    /**
     * Метод выводит номер брони столика.
     * @param reservationId номер брони столика
     */
    public void printReservationTableResult(int reservationId){
        bookingView.printReservationTableResult(reservationId);
    }

    /**
     * Метод выводит сообщение об ошибке
     * @param errorMessage текст сообщения
     */
    public void printReservationTableError(String errorMessage){
        bookingView.printReservationTableError(errorMessage);
    }

    @Override
    public void onReservationTable(Date orderDate, int tableNo, String name) {
        try
        {
            int reservationId = tableModel.reservationTable(orderDate, tableNo, name);
            printReservationTableResult(reservationId);
        }
        catch (RuntimeException e){
            printReservationTableError(e.getMessage());
        }

    }

    /**
     * Метод выводит информацию об отмене брони
     * @param oldReservation Номер брони
     */
    @Override
    public void undoReservation(int oldReservation) {
       if (tableModel.undoReservation(oldReservation)){
           bookingView.printUndoReservationSuccess(oldReservation);
       } else {
           bookingView.printUndoReservationFall(oldReservation);
       }
    }

    @Override
    public void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        if (tableModel.undoReservation(oldReservation)){
            bookingView.printUndoReservationSuccess(oldReservation);
            onReservationTable(reservationDate, tableNo, name);
        } else {
            bookingView.printUndoReservationFall(oldReservation);
        }
    }


}
