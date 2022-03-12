package com.example.sqliteapp58;

public class Computer {


    private int id;
    private String computerName;
    private String computerType;


    // an Empty Constructor of our Computer Class
    public Computer() {


        super();
    }

    public Computer(int id, String computerName, String computerType) {

        this.id = id;
        this.computerName = computerName;
        this.computerType = computerType;

    }


    public Computer(String computerName, String computerType) {

        this.computerName = computerName;
        this.computerType = computerType;


    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public String getComputerType() {
        return computerType;
    }

    public void setComputerType(String computerType) {
        this.computerType = computerType;
    }
}
