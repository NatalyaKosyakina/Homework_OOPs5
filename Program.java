package org.example.lesson5;

import org.example.lesson5.Model.TableModel;
import org.example.lesson5.Presenter.BookingPresenter;
import org.example.lesson5.Presenter.Model;

import org.example.lesson5.View.BookingView;

import java.util.Date;

public class Program {

    /**
     * TODO: Домашняя работа: Метод changeReservationTable ДОЛЖЕН ЗАРАБОТАТЬ!
     * @param args
     */
    public static void main(String[] args) {
        Model tableModel = new TableModel();
        BookingView bookingView = new BookingView();
        BookingPresenter bookingPresenter = new BookingPresenter(tableModel, bookingView);
        bookingPresenter.showTables();

        // Клиент нажимает на кнопку "Зарезервировать", возбуждается событие,
        // вызывается метод reservationTable()
        bookingView.reservationTable(new Date(), 103, "Станислав");

        bookingView.changeReservationTable(1, new Date(), 101, "Станислав");
        bookingView.changeReservationTable(9001, new Date(), 101, "Станислав");
    }

}
