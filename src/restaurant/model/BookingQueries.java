/*
 Name: Bibek Neupane
 12023223

 */
package restaurant.model;

import java.awt.Frame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class BookingQueries {

    static String PASSWORD = ""; // password for the database created which in this case is empty.
    static String URL = "jdbc:derby://localhost:1527/Restaurant"; // database URL
    static String USERNAME = ""; // username for the database created which in this case is empty.
    public static final int CAPACITY = 20; // Total capacity as required is only 20 for any given day.
    // connection and prepared statement
    private Connection connection = null;
    private PreparedStatement insertNewBooking = null;
    private PreparedStatement selectAllBookings = null;
    private PreparedStatement selectBookingsDay = null;
    private PreparedStatement selectTotalDinersForDay = null;

    public BookingQueries() {
        try {

            connection = DriverManager.getConnection(URL);

            insertNewBooking = connection.prepareStatement("INSERT INTO BOOKINGS (LASTNAME,PHONE,DINERS,DAYOFWEEK) VALUES (?,?,?,?)");

            selectAllBookings = connection.prepareStatement("select * from BOOKINGS");

            selectBookingsDay = connection.prepareStatement("select * from BOOKINGS where UPPER(DAYOFWEEK) = UPPER(?)");

            selectTotalDinersForDay = connection.prepareStatement("select DINERS from BOOKINGS where UPPER(DAYOFWEEK) = UPPER(?)");
        } catch (SQLException ex) {
            Logger.getLogger(BookingQueries.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(new Frame(), "Please check your connection.", "Connection error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    public void addBooking(String name, String phone, int reservation, String day) {
        try {
            //these statements below are used to insert the data provided by the user into the database
            insertNewBooking.setString(1, name);
            insertNewBooking.setString(2, phone);
            insertNewBooking.setInt(3, reservation);
            insertNewBooking.setString(4, day);
            insertNewBooking.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BookingQueries.class.getName()).log(Level.SEVERE, null, ex);
            close();
        }
    }

    public void close() {
        try {
            insertNewBooking.close();// close prepare statement
            connection.close();// close the database connection 
        } catch (SQLException ex) {
            Logger.getLogger(BookingQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Booking> getAllBookings() {
        List<Booking> list = new ArrayList<>(); // Booking database is created
        ResultSet r = null;
        try {
            //selectAllBookings is executed.
            r = selectAllBookings.executeQuery();
            // get result and add to the list of booking
            while (r.next()) {
                // add a new Booking object follows this parameters order Booking(int id,String name ,String phone ,int diners , String day)
                list.add(new Booking(r.getInt(1), r.getString(2), r.getString(3), r.getInt(4), r.getString(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookingQueries.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                r.close();
            } catch (SQLException ex) {
                Logger.getLogger(BookingQueries.class.getName()).log(Level.SEVERE, null, ex);
                close();
            }
        }
        return list;
    }

    public List<Booking> getBookingsForDay(String name) {
        List<Booking> list = new ArrayList<>(); // create ArryList of booking
        ResultSet r = null;
        try {
            
            selectBookingsDay.setString(1, name);
            r = selectBookingsDay.executeQuery();
            // get result and add to the list of booking
            while (r.next()) {
                // add a new Booking object follows this parameters order Booking(int id,String name ,String phone ,int diners , String day)
                list.add(new Booking(r.getInt(1), r.getString(2), r.getString(3), r.getInt(4), r.getString(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookingQueries.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                r.close();
            } catch (SQLException ex) {
                Logger.getLogger(BookingQueries.class.getName()).log(Level.SEVERE, null, ex);
                close();
            }
        }
        return list;
    }

    public int getRestaurantCapacity() {
        return CAPACITY;
    }

    public int getTotalDinersForDayDay(String name) {
        int seats = 0; // count for the seats
        try {
            // execute selectTotalDinersForDay prepare statement
            selectTotalDinersForDay.setString(1, name);
            ResultSet r = selectTotalDinersForDay.executeQuery();
            // count the total number of seats
            while (r.next()) {
                seats = seats + r.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookingQueries.class.getName()).log(Level.SEVERE, null, ex);
            close();
        }
        return seats;
    }
}
