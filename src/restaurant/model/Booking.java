/*
Name: Bibek Neupane
12023223

This class contains all the getters and setters method required to return and set the variables.
*/
package restaurant.model;


public class Booking {
    String day;
    int diners;
    int id;
    String name;
    String phone;

    public Booking() {
    }

    public Booking(int id,String name ,String phone ,int diners , String day) {
        this.day = day;
        this.diners = diners;
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getDiners() {
        return diners;
    }

    public void setDiners(int diners) {
        this.diners = diners;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("Id: %d\nName: %s\nPhone: %s\nDiners: %d\nDay of week: %s\n\n", id,name,phone,diners,day);
    }
    
}
