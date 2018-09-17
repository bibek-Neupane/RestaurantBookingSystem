/*
 Name: Bibek Neupane
 12023223

 */
package restaurant.view;

import restaurant.model.Booking;

public interface IView {
    
    void setBrowsing(boolean flag);
    void displayMessage(String s);
    void displayRecord(Booking b);
    
    
    
}
