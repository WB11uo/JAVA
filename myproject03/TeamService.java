package com.atguigu.team.service;

import com.atguigu.team.domain.Architect;
import com.atguigu.team.domain.Designer;
import com.atguigu.team.domain.Employee;
import com.atguigu.team.domain.Programmer;

/**
 * @author PC
 * @program myproject03
 * @description 关于开发团队成员的管理、添加、删除等
 * @create: 2020-12-28 22:52
 **/
public class TeamService {
    private static int counter = 1; //给menberId幅值使用
    private final int MAX_MEMBER = 5; //限制开发团队的人数
    private Programmer[] team = new Programmer[MAX_MEMBER];//保存开发团队成员
    private int total;//记录开发团队中实际人数

    public TeamService() {
        super();
    }

    /**
     * 获取开发团队中的成员
     *
     * @return
     */
    public Programmer[] getTeam() {
        Programmer[] team = new Programmer[total];
        for (int i = 0; i < team.length; i++) {
            team[i] = this.team[i];
        }
        return team;
    }

    /**
     * 将指定员工添加到团队
     *
     * @param e
     */
    public void addMember(Employee e) throws TeamException {
        if (total >= MAX_MEMBER) {
            throw new TeamException("成员已满，无法添加");
        }

        if (!(e instanceof Programmer)) {
            throw new TeamException("该成员不是开发人员，无法添加");
        }

        if (isExist(e)) {
            throw new TeamException("该员工已在开发团队中");
        }

        Programmer p = (Programmer) e;
//        if(p.getStatus().getNAME().equals("BUSY")) {
//        if ("BUSY".equalsIgnoreCase(p.getStatus().getNAME())) {
//            throw new TeamException("该员工已是某团队成员");
//        } else if ("VOCATION".equalsIgnoreCase(p.getStatus().getNAME())) {
//            throw new TeamException("该员工正在休假，无法添加");
//        }

        switch(p.getStatus()) {
            case BUSY:
                throw new TeamException("该员工已是某团队成员");
            case VOCATION:
                throw new TeamException("该员工正在休假，无法添加");
        }

        int numOfArch = 0, numOfDes = 0, numOfPro = 0;
        for (int i = 0; i < total; i++) {
            if (team[i] instanceof Architect) {
                numOfArch++;
            } else if (team[i] instanceof Designer) {
                numOfDes++;
            } else if (team[i] instanceof Programmer) {
                numOfPro++;
            }
        }

        if (p instanceof Architect) {
            if (numOfArch >= 1) throw new TeamException("团队中至多只能有一名架构师");
        } else if (p instanceof Designer) {
            if (numOfDes >= 2) throw new TeamException("团队中至多只能有两名设计师");
        } else if (p instanceof Programmer) {
            if (numOfPro >= 3) throw new TeamException("团队中至多只能有三名程序员");
        }

        team[total++] = p;

        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);

    }

    private boolean isExist(Employee e) {

        for (int i = 0; i < total; i++) {
            if (team[i].getId() == e.getId()) {
                return true;
            }
        }

        return false;
    }

    /**
     * 从团队中删除成员
     *
     * @param menberId
     */
    public void removeMember(int menberId) throws TeamException {
        int i = 0;
        for (; i < total; i++) {
            if (team[i].getMemberId() == menberId) {
                team[i].setStatus(Status.FREE);
                break;
            }
        }

        if (i == total) {
            throw new TeamException("找不到指定员工，删除失败！");
        }

        //后一元素覆盖前一元素
        for (int j = i + 1; j < total; j++) {
            team[j - 1] = team[j];
        }

//        team[total - 1] = null;
//        total--;
        team[--total] = null;

    }
}