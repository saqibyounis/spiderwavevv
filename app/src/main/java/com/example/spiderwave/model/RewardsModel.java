package com.example.spiderwave.model;

public class RewardsModel {

    public long getCradit() {
        return cradit;
    }

    public void setCradit(long cradit) {
        this.cradit = cradit;
    }

    long cradit;
    String promocode;



    public String getPromocode() {
        return promocode;
    }

    public RewardsModel(long cradit, String promocode) {
        this.cradit = cradit;
        this.promocode = promocode;
    }

    public void setPromocode(String promocode) {
        this.promocode = promocode;
    }
public RewardsModel(){}
    public RewardsModel(int cardit, String promocode) {
        this.cradit = cardit;
        this.promocode = promocode;
    }
}
