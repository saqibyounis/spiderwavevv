package com.example.spiderwave.model;

public class LoanModel {

    String laonamount;
    String emi;
    String bank;
    String tenure;

    public String getLaonamount() {
        return laonamount;
    }

    public void setLaonamount(String laonamount) {
        this.laonamount = laonamount;
    }

    public String getEmi() {
        return emi;
    }

    public void setEmi(String emi) {
        this.emi = emi;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getTenure() {
        return tenure;
    }

    public void setTenure(String tenure) {
        this.tenure = tenure;
    }

    public LoanModel(String laonamount, String emi, String bank, String tenure) {
        this.laonamount = laonamount;
        this.emi = emi;
        this.bank = bank;
        this.tenure = tenure;
    }
}
