/*
Name: Bibek Neupane
12023223

IModel interface which consists of all the methods
*/
package restaurant.model;


public interface IModel {
    int getRestaurantCapacity();
    int getAllBookings();
    int getBookingsForDay(String day);
    int addBooking(String name, String phone, int diners, String day);
    int getTotalDinersForDay(String day);
    
    void close();
    int previous();
    int next();
    Booking current();
    
}
