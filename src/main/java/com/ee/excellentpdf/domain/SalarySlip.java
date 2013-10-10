package com.ee.excellentpdf.domain;

public class SalarySlip {
    private String name;
    private String month;
    private String daysInMonth;
    private String daysPresent;
    private String designation;
    private String backAccountNumber;
    private String monthlyCTC;
    private String basic;
    private String lta;
    private String hra;
    private Double conveyanceAllowance;
    private String teleExpense;
    String medicalReimbursement;
    String incrementDifference;
    String leaveEncashment;
    String specialAllowance;
    String referralBonus;
    String totalEarn;
    Double professionalTax;
    Double pf;
    Double tds;
    Double totalDeduction;
    Double totalSalary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDaysInMonth() {
        return daysInMonth;
    }

    public void setDaysInMonth(String daysInMonth) {
        this.daysInMonth = daysInMonth;
    }

    public String getDaysPresent() {
        return daysPresent;
    }

    public void setDaysPresent(String daysPresent) {
        this.daysPresent = daysPresent;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getBackAccountNumber() {
        return backAccountNumber;
    }

    public void setBackAccountNumber(String backAccountNumber) {
        this.backAccountNumber = backAccountNumber;
    }

    public String getMonthlyCTC() {
        return monthlyCTC;
    }

    public void setMonthlyCTC(String monthlyCTC) {
        this.monthlyCTC = monthlyCTC;
    }

    public String getBasic() {
        return basic;
    }

    public void setBasic(String basic) {
        this.basic = basic;
    }

    public String getLta() {
        return lta;
    }

    public void setLta(String lta) {
        this.lta = lta;
    }

    public String getHra() {
        return hra;
    }

    public void setHra(String hra) {
        this.hra = hra;
    }

    public Double getConveyanceAllowance() {
        return conveyanceAllowance;
    }

    public void setConveyanceAllowance(Double conveyanceAllowance) {
        this.conveyanceAllowance = conveyanceAllowance;
    }

    public String getTeleExpense() {
        return teleExpense;
    }

    public void setTeleExpense(String teleExpense) {
        this.teleExpense = teleExpense;
    }
}
