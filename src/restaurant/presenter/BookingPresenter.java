/**
 *
 * @author Bibek Neupane - 12023223
 */
package restaurant.presenter;

import restaurant.model.IModel;
import restaurant.view.IView;


public class BookingPresenter {

    private IModel model;
    private IView view;

    public BookingPresenter(IModel m) {
        model = m;
    }

    public void bind(IView v) {
        view = v;
    }
    
   
    
    public void allBookings(){   //getallbooking method is called to display all the bookings
        view.setBrowsing(true);
        model.getAllBookings();
        view.displayRecord(model.current());
    }
    
    public void bookingsForDay(String day){//getBookingForDay is called to display the total bookings for any given day
        view.setBrowsing(true);            //as entered by the user in the day field
        model.getBookingsForDay(day);
        view.displayRecord(model.current());
    }
    
    public void addBooking(String name, String phone, int number, String day){
        int totalDiners = model.getTotalDinersForDay(day);//Users can enter and book a new booking for any day
        if(number+totalDiners>=20){//if the booking exceeds the capacity i.e. 20 then booking cannot be made
            view.displayMessage("SORRY NO BOOKINGS AVAILABLE FOR THE DAY");
            
        }else{
        model.addBooking(name, phone, number, day);
        view.displayMessage("BOOKED");
        }
        
    }
    
    public void totalDinersForDay(String day){//total diners booked for any day is calculated
        if (model.getTotalDinersForDay(day)==0){
            view.displayMessage("NO BOOKINGS FOR THE DAY");
        }else
            view.displayMessage("DINERS FOR "+day+" : " +model.getTotalDinersForDay(day));
    }
    
    public void previous(){//previous button
        model.previous();
        view.displayRecord(model.current());
        
    }
    
    public void next(){//next button
        model.next();
        view.displayRecord(model.current());
    }
    
    public void close(){//closees the application
        model.close();
    }
    
    

    
    

}
