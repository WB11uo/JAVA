package com.atguigu.team.service;

public class TeamException extends Exception {
    static final long serialVersionUID = -3383124229948L;

    public TeamException(){
        super();
    }

    public TeamException(String msg) {
        super(msg);
    }
}
