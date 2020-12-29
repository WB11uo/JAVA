package com.atguigu.team.domain;

import com.atguigu.team.service.Status;

public class Programmer extends Employee {

    private int memberId;//开发团队中的ID
    private Status status = Status.FREE;
    private Equipment equipment;

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public int getMemberId() {

        return memberId;
    }

    public Status getStatus() {
        return status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public Programmer() {

    }

    @Override
    public String toString() {
        return getDetails() + "\t程序员\t" + status + "\t\t\t\t\t" + equipment.getDescription();
    }

    public String getTeamBaseDetails() {
        return memberId + "/" + getId() + "\t" + getName() + "\t" + getAge() + "\t" +getSalary();
    }
    public String getDetailsForTeam() {
        return getTeamBaseDetails() + "\t程序员";
    }
}
