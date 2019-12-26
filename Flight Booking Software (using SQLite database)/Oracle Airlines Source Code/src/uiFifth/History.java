/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uiFifth;

/**
 *
 * @author HimelSaha
 */
public class History {

    private int serials;
    private String passengers;
    private String froms;
    private String tos;
    private String dates;
    private String classess;
    private String seats;
    private String flightNos;
    private String emails;
    private String genders;
    private String passports;
    private String phones;

    public History(String passengers, String froms, String tos, String dates, String classess, String seats, String flightNos, String emails, String genders, String passports, String phone) {
        this.passengers = passengers;
        this.froms = froms;
        this.tos = tos;
        this.dates = dates;
        this.classess = classess;           // WITHOUT INT
        this.seats = seats;
        this.flightNos = flightNos;
        this.emails = emails;
        this.genders = genders;
        this.passports = passports;
        this.phones = phone;
    }

    public History(int serials, String passengers, String froms, String tos, String dates, String classess, 
            String seats, String flightNos, String emails, String genders, String passports, String phones) {
        this.serials = serials;
        this.passengers = passengers;
        this.froms = froms;
        this.tos = tos;
        this.dates = dates;
        this.classess = classess;
        this.seats = seats;                 // WITH INT 
        this.flightNos = flightNos;
        this.emails = emails;
        this.genders = genders;
        this.passports = passports;
        this.phones = phones;
    }
    String dateForSeat;                         // FOR SEAT MOD
    String depCityToCheck;
    String arrCityToCheck;
    String seatToCheck;
    public History(String dateForSeat, String depCityToCheck, String arrCityToCheck, String seatToCheck) {
        this.dateForSeat = dateForSeat;
        this.depCityToCheck = depCityToCheck;
        this.arrCityToCheck = arrCityToCheck;
        this.seatToCheck = seatToCheck;
    }

    public String getDateForSeat() {
        return dateForSeat;
    }

    public String getDepCityToCheck() {
        return depCityToCheck;
    }

    public String getArrCityToCheck() {
        return arrCityToCheck;
    }

    public String getSeatToCheck() {
        return seatToCheck;
    }
    ////////////////////////////////////////////////////////////////

    public int getSerials() {
        return serials;
    }

    public String getPassengers() {
        return passengers;
    }

    public String getFroms() {
        return froms;
    }

    public String getTos() {
        return tos;
    }

    public String getDates() {
        return dates;
    }

    public String getClassess() {
        return classess;
    }

    public String getSeats() {
        return seats;
    }

    public String getFlightNos() {
        return flightNos;
    }

    public String getEmails() {
        return emails;
    }

    public String getGenders() {
        return genders;
    }

    public String getPassports() {
        return passports;
    }

    public String getPhones() {
        return phones;
    }

}
