/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uiFirst;

import dbconnection.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import uiFifth.History;
import uiSixth.Sixth;

/**
 *
 * @author HimelSaha
 */
public class CityDaoImpl implements CityDao {

    Connection conn = DbConnection.getConnection();

    public CityDaoImpl() {
    }

    @Override
    public List<String> city() {
        List<String> fromCity = new ArrayList();
        fromCity.add("Dhaka");
        fromCity.add("Singapore City");
        fromCity.add("Bangkok");
        fromCity.add("Istanbul");

        return fromCity;
    }

    @Override
    public List<String> day() {
        List<String> days = new ArrayList();
        for (int i = 1; i <= 31; i++) {
            if (i < 10) {
                days.add("0" + i);
            } else {
            days.add("" + i);
            }
        }
        return days;
    }

    @Override
    public List<String> month() {
        List<String> months = new ArrayList();
        for (int i = 1; i <= 12; i++) {
            if (i < 10) {
                months.add("0" + i);
            } else {
            months.add("" + i);
            }
        }
        return months;
    }

    @Override
    public List<String> year() {
        List<String> years = new ArrayList();
        years.add("2019");
        years.add("2020");
        years.add("2021");
        return years;
    }

    @Override
    public List<String> travelClass() {
        List<String> classes = new ArrayList();
        classes.add("Select A Student");
        classes.add("Economy Class");
        classes.add("Business Class");
        return classes;
    }

    static String dateToCheck, depCityToCheck, arrCityToCheck;

    public CityDaoImpl(String datesToCheck, String depCitysToCheck, String arrCitysToCheck) {
        this.dateToCheck = datesToCheck;
        this.depCityToCheck = depCitysToCheck;
        this.arrCityToCheck = arrCitysToCheck;
    }

    @Override
    public List<String> economySeats() {
        List<String> economy = new ArrayList();
        List<String> ecoSeatsMod = new ArrayList();

        for (int i = 6; i <= 20; i++) {
            economy.add(i + "A");
            economy.add(i + "B");
            economy.add(i + "C");
        }

        List<String> x = economy;
        if (seatModCheck(dateToCheck, depCityToCheck, arrCityToCheck)) {
            boolean boo;
            for (String i : economy) {
                boo = false;

                for (String e : seatRecordList) {
                    if (i.equalsIgnoreCase(e)) {
                        boo = true;
                    }
                }
                if (boo == false) {
                    ecoSeatsMod.add(i);
                }
            }
            x = ecoSeatsMod;

        }
        return x;
    }

    @Override
    public List<String> businessSeats() {
        List<String> business = new ArrayList();
        List<String> busSeatsMod = new ArrayList();
        for (int i = 1; i <= 5; i++) {
            business.add(i + "A");
            business.add(i + "B");
        }
        List<String> y = business;
        if (seatModCheck(dateToCheck, depCityToCheck, arrCityToCheck)) {
            boolean boo;
            for (String i : business) {
                boo = false;

                for (String e : seatRecordList) {
                    if (i.equalsIgnoreCase(e)) {
                        boo = true;
                    }
                }
                if (boo == false) {
                    busSeatsMod.add(i);
                }
            }
            y = busSeatsMod;

        }
        return y;
    }

    // DATABASE FUNCTIONALITIES
    @Override
    public void insert(History history) {
        String sql = "insert into travels (passenger, dep, arr, date, class, seat, flight_no, email, gender, "
                + "passport, phone) values(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, history.getPassengers());
            ps.setString(2, history.getFroms());
            ps.setString(3, history.getTos());
            ps.setString(4, history.getDates());
            ps.setString(5, history.getClassess());
            ps.setString(6, history.getSeats());
            ps.setString(7, history.getFlightNos());
            ps.setString(8, history.getEmails());
            ps.setString(9, history.getGenders());
            ps.setString(10, history.getPassports());
            ps.setString(11, history.getPhones());

            ps.executeUpdate();
            System.out.println("Data Inserted Successfully");
        } catch (SQLException ex) {
            System.out.println("Error while inserting data");
        }
    }

    @Override
    public void delete(String deleteId) {
        String sql = "delete from travels where serial=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, deleteId);
            ps.executeUpdate();
            System.out.println("Deleted from database successfully");
        } catch (SQLException ex) {
            System.out.println("Error while deleting data");
        }
    }

    @Override
    public void update(String passenger, String date, String email, String gender, String passport, String phone, String serial) {

        String sql = "update travels set passenger=?, date=?, email=?, gender=?, passport=?, phone=? where serial=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, passenger);
            ps.setString(2, date);
            ps.setString(3, email);
            ps.setString(4, gender);
            ps.setString(5, passport);
            ps.setString(6, phone);
            ps.setString(7, serial);
            ps.executeUpdate();
            System.out.println("Database Updated Successfully");

        } catch (SQLException ex) {
            System.out.println("Error while updating data");
        }
    }

    @Override
    public List<History> getList() {
        List<History> list = new ArrayList();

        String sql = "select * from travels";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                History history = new History(rs.getInt("serial"), rs.getString("passenger"), rs.getString("dep"), rs.getString("arr"), 
                        rs.getString("date"), rs.getString("class"), rs.getString("seat"), rs.getString("flight_no"), rs.getString("email"), 
                        rs.getString("gender"), rs.getString("passport"), rs.getString("phone"));
                list.add(history);
            }

        } catch (SQLException ex) {
            System.out.println("Error while fetching data");
        }

        return list;
    }

    @Override
    public List<History> seatMod() {
        List<History> list = new ArrayList();

        String sql = "select * from travels";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                History historyForSeat = new History(rs.getString("date"), rs.getString("dep"), rs.getString("arr"), rs.getString("seat"));
                list.add(historyForSeat);
                
            }

        } catch (SQLException ex) {
            System.out.println("Error while fetching data");
        }
        return list;
    }

    @Override
    public boolean seatModCheck(String datesToCheck, String depCitysToCheck, String arrCitysToCheck) {
        List<History> list = seatMod();
        boolean x = false;

        for (int i = 0; i < list.size(); i++) {

            if ((list.get(i).getDateForSeat().equalsIgnoreCase(datesToCheck)) && 
                    (list.get(i).getDepCityToCheck().equalsIgnoreCase(depCitysToCheck)) && 
                    (list.get(i).getArrCityToCheck().equalsIgnoreCase(arrCitysToCheck))) {
                
                System.out.println(list.get(i).getSeatToCheck());
                seatRecorded(list.get(i).getSeatToCheck());
                
                x = true;
            }
        }

        return x;
    }

    List<String> seatRecordList = new ArrayList();

    @Override
    public void seatRecorded(String seatToRecord) {
        seatRecordList.add(seatToRecord);
        
    }

}
