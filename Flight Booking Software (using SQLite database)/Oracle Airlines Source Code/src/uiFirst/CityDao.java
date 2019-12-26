/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uiFirst;

import java.util.List;
import uiFifth.History;

/**
 *
 * @author HimelSaha
 */
public interface CityDao {
    
    List<String> city();
    List<String> day();
    List<String> month();
    List<String> year();
    List<String> travelClass();   
    List<String> economySeats();
    List<String> businessSeats();
    
    // DATABASE FUNCTIONALITIES
    
    void insert(History history);
    void delete(String deleteId);
    List<History> seatMod();
    public boolean seatModCheck(String dateToCheck, String depCityToCheck, String arrCityToCheck);
    void seatRecorded(String seatToRecord);
    void update(String passenger, String date, String email, String gender, String passport, String phone, String serial);
    List<History> getList();
    
}