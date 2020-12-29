package com.atguigu.team.domain;

public class Architect extends Designer {

    private int stock;

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStock() {

        return stock;
    }

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {

        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public Architect() {

    }

    @Override
    public String toString() {
        return getDetails() + "\t架构师\t" + getStatus() + "\t" + getBonus() + "\t" + getStock() + "\t" + getEquipment().getDescription();
    }

    public String getDetailsForTeam() {
        return getTeamBaseDetails() + "\t架构师\t" + getBonus() + "\t" + getStock();
    }
}
