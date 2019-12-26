/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uiFifth;

import uiFirst.CityDaoImpl;

/**
 *
 * @author HimelSaha
 */
public class ImportData {

    public static void main(String[] args) {

        printFirst();
        printSecond();
        printThird();
        

    }

    public ImportData() {
    }

    //for First
    static String departingCity, arrivalCity, date, travelClass, flightNo, seat, name, email, gender, phone, passport;
    

    public ImportData(String departingCitys, String arrivalCitys, String dates, String travelClasses) {
        this.departingCity = departingCitys;
        this.arrivalCity = arrivalCitys;
        this.date = dates;
        this.travelClass = travelClasses;
        
    }
    
    static String flightPrice;
    
    int z;
    public ImportData(String price, int x) {
        this.flightPrice = price;
        this.z = x;
    }
    
    // FOR FLIGHT NO.
    double y;
    public ImportData(String flightNo, double x) {
        this.flightNo = flightNo;
        this.y = x;
    }

    public static void printFirst() {
        System.out.println(departingCity);
        System.out.println(arrivalCity);
        System.out.println(date);
        System.out.println(travelClass);

    }

    // for Second
    public ImportData(String seats) {
        this.seat = seats;
    }

    public static void printSecond() {
        System.out.println(seat);
    }

    // for Third
    public ImportData(String names, String emails, String genders, String phones, String passports) {
        this.name = names;
        this.email = emails;
        this.gender = genders;
        this.phone = phones;
        this.passport = passports;
    }

    public static void printThird() {
        System.out.println(name.toUpperCase());
        System.out.println(email.toLowerCase());
        System.out.println(gender);
        System.out.println(phone);
        System.out.println(passport);
        
        History sketch = new History(name.toUpperCase(), departingCity, arrivalCity, date, travelClass, seat, flightNo, 
                email.toLowerCase(), gender, passport, phone);
        new CityDaoImpl().insert(sketch);
        
    }

    // FOR BACK FUNCTION

    public static String getDepartingCity() {
        return departingCity;
    }

    public static String getArrivalCity() {
        return arrivalCity;
    }
    
    public static String getTravelClass() {
        return travelClass;
    }

    public static String getFlightNo() {
        return flightNo;
    }

    public static String getSeat() {
        return seat;
    }

    public static String getName() {
        return name;
    }

    public static String getEmail() {
        return email;
    }

    public static String getGender() {
        return gender;
    }

    public static String getPhone() {
        return phone;
    }

    public static String getPassport() {
        return passport;
    }

    public static String getDate() {
        return date;
    }

    public static String getFlightPrice() {
        return flightPrice;
    }
    
    
    
    

}
