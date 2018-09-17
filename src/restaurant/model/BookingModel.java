/*
Name: Bibek Neupane
12023223
*/
package restaurant.model;


import java.util.List;

public class BookingModel implements IModel {

    private BookingQueries queries;
    private List<Booking> bookings;
    private int index;
    private Booking current;
    private int nBookings;

    public BookingModel(BookingQueries bq) {
        queries = bq;
    }

    @Override
    public int getRestaurantCapacity() {
        return queries.getRestaurantCapacity();

    }

    @Override
    public int getAllBookings() {
        bookings=queries.getAllBookings();
        nBookings=bookings.size();
        index=0;
        return nBookings;

    }

    @Override
    public int getBookingsForDay(String day) {
        bookings=queries.getBookingsForDay(day);
        nBookings=bookings.size();
        index=0;
        return nBookings;
        

    }

    @Override
    public int addBooking(String name, String phone, int diners, String day) {
        queries.addBooking(name, phone, diners, day);
        return 2;

    }

    @Override
    public int getTotalDinersForDay(String day) {
        return queries.getTotalDinersForDayDay(day);

    }

    @Override
    public void close() {
        queries.close();

    }

    @Override
    public int previous() {
        index--;
        if (index <= nBookings) {
            index = (nBookings-1);
        }
        return index;

    }

    @Override
    public int next() {
        index++;
        if (index >= nBookings) {
            index = 0;
        }
        return index;

    }

    @Override
    public Booking current() {
        current = bookings.get(index);
        return current;

    }

}
