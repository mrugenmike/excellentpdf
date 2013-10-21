package com.ee.excellentpdf.domain;

import java.util.Map;

public class SalarySlip {
    private String name;
    private String month;
    private Double daysInMonth;
    private Double daysPresent;
    private String designation;
    private String bankAccountNumber;
    private Double monthlyCTC;
    private Double basic;
    private Double lta;
    private Double hra;
    private Double conveyanceAllowance;
    private Double teleExpense;
    private Double medicalReimbursement;
    private Double incrementDifference;
    private Double leaveEncashment;
    private Double  specialAllowance;
    private Double referralBonus;
    private Double totalEarn;
    private Double professionalTax;
    private Double pf;
    private Double tds;
    private Double totalDeduction;
    private Double totalSalary;
    private String email;

    public SalarySlip(Map<String, Object> mapOfCellsValue) {
        this.name = (String)mapOfCellsValue.get("Name");
        this.month = (String) mapOfCellsValue.get("Month");
        this.email = (String) mapOfCellsValue.get("Email");
        this.daysInMonth = (Double) mapOfCellsValue.get("Days in a month");
        this.daysPresent=(Double) mapOfCellsValue.get("Days Present");
        this.designation = (String) mapOfCellsValue.get("Designation");
        this.bankAccountNumber =(String) mapOfCellsValue.get("Bank A/c No");
        this.monthlyCTC = (Double) mapOfCellsValue.get("Monthly CTC");
        this.basic = (Double)mapOfCellsValue.get("Basic");
        this.hra = (Double)mapOfCellsValue.get("HRA");
        this.lta = (Double) mapOfCellsValue.get("LTA");
        this.conveyanceAllowance = (Double)mapOfCellsValue.get("Con Allow");
        this.teleExpense = (Double) mapOfCellsValue.get("Tele Exp Reimb");
        this.medicalReimbursement = (Double) mapOfCellsValue.get("Medical Reimb");
        this.incrementDifference = (Double) mapOfCellsValue.get("Increment Diffrence");
        this.leaveEncashment = (Double) mapOfCellsValue.get("Leave Encashment");
        this.specialAllowance = (Double) mapOfCellsValue.get("Spcl Allow");
        this.referralBonus = (Double) mapOfCellsValue.get("Referal Bonus & Bonus");
        this.totalEarn = (Double) mapOfCellsValue.get("Total Earn");
        this.professionalTax = (Double) mapOfCellsValue.get("P Tax");
        this.pf = (Double) mapOfCellsValue.get("PF");
        this.tds = (Double) mapOfCellsValue.get("TDS");
        this.totalDeduction = (Double) mapOfCellsValue.get("Total Ded");
        this.totalSalary = (Double) mapOfCellsValue.get("Total Salary");


    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMonth() {
        return month;
    }

    public Double getDaysInMonth() {
        return daysInMonth;
    }


    public Double getDaysPresent() {
        return daysPresent;
    }


    public String getDesignation() {
        return designation;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public Double getMonthlyCTC() {
        return monthlyCTC;
    }

    public Double getBasic() {
        return basic;
    }

    public Double getLta() {
        return lta;
    }

    public Double getHra() {
        return hra;
    }


    public Double getConveyanceAllowance() {
        return conveyanceAllowance;
    }

    public void setConveyanceAllowance(Double conveyanceAllowance) {
        this.conveyanceAllowance = conveyanceAllowance;
    }

    public Double getTeleExpense() {
        return teleExpense;
    }
}
