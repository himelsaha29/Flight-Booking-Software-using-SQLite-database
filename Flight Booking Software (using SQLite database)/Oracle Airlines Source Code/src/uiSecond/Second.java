/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uiSecond;

import java.awt.Color;
import java.time.LocalTime;
import static java.time.temporal.ChronoUnit.MINUTES;
import java.util.*;
import uiFifth.ImportData;
import uiFirst.CityDao;
import uiFirst.CityDaoImpl;
import uiFirst.First;
import uiFourth.Fourth;
import uiThird.Third;

/**
 *
 * @author HimelSaha
 */
public class Second extends javax.swing.JFrame {

    /**
     * Creates new form Second
     */
    public Second() {
        initComponents();

    }

    // FOR BACK BUTTON
    int y;
    private String fullDate = jrnDay + "/" + jrnMonth + "/" + jrnYear;
    private String flightNo;

    public Second(String departingCitys, String arrivalCitys, String jrnDays, String jrnMonths, String jrnYears, String travelClasses, int x) {
        initComponents();
        this.departingCity = departingCitys;
        this.arrivalCity = arrivalCitys;
        this.jrnDay = jrnDays;
        this.jrnMonth = jrnMonths;
        this.jrnYear = jrnYears;
        this.travelClass = travelClasses;
        this.y = x;
        passData();
        // COLORS
        this.getContentPane().setBackground(Color.pink);
        btnPersonal.setBackground(Color.cyan);
        txtArrival.setBackground(Color.pink);
        txtArrivalTime.setBackground(Color.pink);
        txtDeparture.setBackground(Color.pink);
        txtDepartureTime.setBackground(Color.pink);
        txtCraft.setBackground(Color.pink);
        txtDuration.setBackground(Color.pink);
        txtPrice.setBackground(Color.pink);
        txtTravelClass.setBackground(Color.pink);
        txtTravelDate.setBackground(Color.pink);
        //------------------------------------------
        cmbSeats.setSelectedItem(ImportData.getSeat());
    }

    CityDao seats = new CityDaoImpl();

    static String departingCity, arrivalCity, jrnYear, travelClass;
    private static String jrnDay, jrnMonth;
    

    public static String getJrnDay() {
        return jrnDay;
    }

    public static String getJrnMonth() {
        return jrnMonth;
    }

    public static String getJrnYear() {
        return jrnYear;
    }

    public static String getTravelClass() {
        return travelClass;
    }

    public Second(String departingCitys, String arrivalCitys, String jrnDays, String jrnMonths, String jrnYears, String travelClasses) {
        initComponents();
        this.departingCity = departingCitys;
        this.arrivalCity = arrivalCitys;
        this.jrnDay = jrnDays;
        this.jrnMonth = jrnMonths;
        this.jrnYear = jrnYears;
        this.travelClass = travelClasses;
        passData();
        // COLORS
        this.getContentPane().setBackground(Color.pink);
        btnPersonal.setBackground(Color.cyan);
        txtArrival.setBackground(Color.pink);
        txtArrivalTime.setBackground(Color.pink);
        txtDeparture.setBackground(Color.pink);
        txtDepartureTime.setBackground(Color.pink);
        txtCraft.setBackground(Color.pink);
        txtDuration.setBackground(Color.pink);
        txtPrice.setBackground(Color.pink);
        txtTravelClass.setBackground(Color.pink);
        txtTravelDate.setBackground(Color.pink);
    }

    public void passData() {
        txtDeparture.setText(departingCity);
        txtArrival.setText(arrivalCity);
        txtTravelDate.setText(jrnDay + "/" + jrnMonth + "/" + jrnYear);
        txtTravelClass.setText(travelClass);
        lblWarningSeats.setVisible(false);

        String classPrice = null;
        String currency = "USD";
        double dollar = 0.0;
         
        //----------------------------CRAFT CHOICE-------------------------------
        if ((departingCity == "Singapore City" || arrivalCity == "Singapore City")) {
            txtCraft.setText("Boeing 777-300ER");
        }
        if ((departingCity == "Istanbul" || arrivalCity == "Istanbul")) {
            txtCraft.setText("B787 Dreamliner");
        }
        if ((!(departingCity == "Singapore City" || arrivalCity == "Singapore City")) && (!(departingCity == "Istanbul" || arrivalCity == "Istanbul"))) {
            txtCraft.setText("Airbus A380");
        }

        //------------------------------PRICE FOR EACH FLIGHT ROUTE----------------------
        if ((departingCity == "Singapore City" || departingCity == "Dhaka") && (arrivalCity == "Singapore City" || arrivalCity == "Dhaka")) {
            dollar = 454.94;
            txtDuration.setText("4hr 45min");
            txtDepartureTime.setText("13.05");
            txtArrivalTime.setText("15.15");
            flightNo = "OR237";
        }
        if ((departingCity == "Bangkok" || departingCity == "Dhaka") && (arrivalCity == "Bangkok" || arrivalCity == "Dhaka")) {
            dollar = 319.67;
            txtDuration.setText("3hr 30min");
            txtDepartureTime.setText("07.25");
            txtArrivalTime.setText("09.45");
            flightNo = "OR587";
        }
        if ((departingCity == "Istanbul" || departingCity == "Dhaka") && (arrivalCity == "Istanbul" || arrivalCity == "Dhaka")) {
            dollar = 779.52;
            txtDuration.setText("7hr 45min");
            txtDepartureTime.setText("02.25");
            txtArrivalTime.setText("08.20");
            flightNo = "OR746";
        }
        if ((departingCity == "Bangkok" || departingCity == "Singapore City") && (arrivalCity == "Bangkok" || arrivalCity == "Singapore City")) {
            dollar = 236.01;
            txtDuration.setText("2hr 15min");
            txtDepartureTime.setText("16.05");
            txtArrivalTime.setText("17.50");
            flightNo = "OR057";
        }
        if ((departingCity == "Istanbul" || departingCity == "Singapore City") && (arrivalCity == "Istanbul" || arrivalCity == "Singapore City")) {
            dollar = 850.32;
            txtDuration.setText("9hr 35min");
            txtDepartureTime.setText("11.15");
            txtArrivalTime.setText("19.25");
            flightNo = "OR319";
        }
        if ((departingCity == "Istanbul" || departingCity == "Bangkok") && (arrivalCity == "Istanbul" || arrivalCity == "Bangkok")) {
            dollar = 747.98;
            txtDuration.setText("8hr 00min");
            txtDepartureTime.setText("14.40");
            txtArrivalTime.setText("22.35");
            flightNo = "OR971";
        }//-------------------------------------------------------------------------------------------------------------------------------------------------
        
        if (travelClass == "Economy Class") {
            classPrice = String.valueOf(dollar) + " " + currency;
            txtPrice.setText(classPrice);
            displayDataintoEconomyCombo();

        } else {
            double businessDollar = dollar + 150.50;
            classPrice = String.valueOf(businessDollar) + " " + currency;
            txtPrice.setText(classPrice);
            displayDataintoBusinessCombo();

        }
    }

    public void displayDataintoEconomyCombo() {
        List<String> list = seats.economySeats();
        cmbSeats.removeAllItems();
        cmbSeats.addItem("Select seat");
        for (String s : list) {
            cmbSeats.addItem(s);
        }
    }

    public void displayDataintoBusinessCombo() {
        List<String> list = seats.businessSeats();
        cmbSeats.removeAllItems();
        cmbSeats.addItem("Select seat");
        for (String s : list) {
            cmbSeats.addItem(s);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDeparture = new javax.swing.JLabel();
        lblArrival = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtDeparture = new javax.swing.JTextField();
        txtArrival = new javax.swing.JTextField();
        txtTravelDate = new javax.swing.JTextField();
        lblDepartureTime = new javax.swing.JLabel();
        lblArrivalTime = new javax.swing.JLabel();
        txtDepartureTime = new javax.swing.JTextField();
        txtArrivalTime = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnPersonal = new javax.swing.JButton();
        lblPrice = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        lblDuration = new javax.swing.JLabel();
        txtDuration = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTravelClass = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmbSeats = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        txtCraft = new javax.swing.JTextField();
        lblWarningSeats = new javax.swing.JLabel();
        btnGoBack2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblDeparture.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblDeparture.setText("Departure:");

        lblArrival.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblArrival.setText("Arrival:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setText("Travel date:");

        txtDeparture.setEditable(false);
        txtDeparture.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtDeparture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDepartureActionPerformed(evt);
            }
        });

        txtArrival.setEditable(false);
        txtArrival.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        txtTravelDate.setEditable(false);
        txtTravelDate.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        lblDepartureTime.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblDepartureTime.setText("at");

        lblArrivalTime.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblArrivalTime.setText("at");

        txtDepartureTime.setEditable(false);
        txtDepartureTime.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtDepartureTime.setText(" 03.05 ");

        txtArrivalTime.setEditable(false);
        txtArrivalTime.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtArrivalTime.setText(" 05.27 ");
        txtArrivalTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtArrivalTimeActionPerformed(evt);
            }
        });

        jLabel2.setText("*All times are listed as local times");

        btnPersonal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnPersonal.setText("Proceed to Personal Information");
        btnPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonalActionPerformed(evt);
            }
        });

        lblPrice.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        lblPrice.setText("Total Price:");

        txtPrice.setEditable(false);
        txtPrice.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N

        lblDuration.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblDuration.setText("Duration:");

        txtDuration.setEditable(false);
        txtDuration.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtDuration.setText(" 4hr 35m ");
        txtDuration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDurationActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setText("Travel Class:");

        txtTravelClass.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setText("Seat:");

        cmbSeats.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel5.setText("Aircraft");

        txtCraft.setEditable(false);
        txtCraft.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        lblWarningSeats.setForeground(new java.awt.Color(255, 51, 51));
        lblWarningSeats.setText("Please select your seat");

        btnGoBack2.setText("Go Back");
        btnGoBack2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBack2ActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(153, 153, 255));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Orator Std", 2, 48)); // NOI18N
        jTextArea1.setRows(1);
        jTextArea1.setText(" Flight Details");
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 185, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 182, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 188, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 187, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 157, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDeparture)
                    .addComponent(lblArrival)
                    .addComponent(jLabel1)
                    .addComponent(lblPrice)
                    .addComponent(jLabel3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDeparture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTravelDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtArrival, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTravelClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblDepartureTime)
                                            .addComponent(lblArrivalTime))
                                        .addGap(45, 45, 45)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtDepartureTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtArrivalTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(lblDuration))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmbSeats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtCraft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(142, 142, 142)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnGoBack2)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(35, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblWarningSeats)
                .addGap(417, 417, 417))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDeparture)
                    .addComponent(txtDeparture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDepartureTime)
                    .addComponent(txtDepartureTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblArrival)
                    .addComponent(txtArrival, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblArrivalTime)
                    .addComponent(txtArrivalTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTravelDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDuration)
                    .addComponent(txtDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtCraft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTravelClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cmbSeats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrice)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(lblWarningSeats)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGoBack2))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDepartureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDepartureActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDepartureActionPerformed

    private void txtArrivalTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtArrivalTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtArrivalTimeActionPerformed

    private void btnPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonalActionPerformed
        // TODO add your handling code here:
        if (cmbSeats.getSelectedItem().toString() == "Select seat") {
            lblWarningSeats.setVisible(true);

        } else {
            new ImportData(cmbSeats.getSelectedItem().toString());
            new ImportData(txtPrice.getText(), 10);
            new ImportData(flightNo, 10.00);
            new Third(ImportData.getFlightPrice()).setVisible(true);

            this.setVisible(false);
        }
    }//GEN-LAST:event_btnPersonalActionPerformed

    private void txtDurationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDurationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDurationActionPerformed

    private void btnGoBack2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBack2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new First(jrnYear).setVisible(true);
    }//GEN-LAST:event_btnGoBack2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Second.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Second.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Second.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Second.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Second().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoBack2;
    private javax.swing.JButton btnPersonal;
    private javax.swing.JComboBox cmbSeats;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblArrival;
    private javax.swing.JLabel lblArrivalTime;
    private javax.swing.JLabel lblDeparture;
    private javax.swing.JLabel lblDepartureTime;
    private javax.swing.JLabel lblDuration;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblWarningSeats;
    private javax.swing.JTextField txtArrival;
    private javax.swing.JTextField txtArrivalTime;
    private javax.swing.JTextField txtCraft;
    private javax.swing.JTextField txtDeparture;
    private javax.swing.JTextField txtDepartureTime;
    private javax.swing.JTextField txtDuration;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtTravelClass;
    private javax.swing.JTextField txtTravelDate;
    // End of variables declaration//GEN-END:variables
}
