/*
Name: Bibek Neupane
12023223
*/
package restaurant;

import restaurant.model.BookingModel;
import restaurant.model.BookingQueries;
import restaurant.model.IModel;
import restaurant.presenter.BookingPresenter;
import restaurant.view.BookingView;
import restaurant.view.IView;



public class Restaurant {

   
    public static void main(String[] args) {
        BookingQueries bq = new BookingQueries();
        IModel m = new BookingModel(bq);
        BookingPresenter p = new BookingPresenter(m);
        IView v = new BookingView(p);
        p.bind(v);

        
    }

}
