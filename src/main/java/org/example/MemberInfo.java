package org.example;

public class MemberInfo {
    private int id;
    private int flatNumber;
    private int numberOfRooms;
    private int square;
    private String street;
    private int buildingNumber;
    private String name;
    private String eMail;
    private int tel;
    private char entry_by_car;

    public MemberInfo() {
    }

    public MemberInfo(int id, int flatNumber, int numberOfRooms, int square, String street,
                      int buildingNumber, String name, String eMail, int tel, char entry_by_car) {
        this.id = id;
        this.flatNumber = flatNumber;
        this.numberOfRooms = numberOfRooms;
        this.square = square;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.name = name;
        this.eMail = eMail;
        this.tel = tel;
        this.entry_by_car = entry_by_car;
    }

    public int getId() {
        return id;
    }

    public MemberInfo setId(int id) {
        this.id = id;
        return this;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public MemberInfo setBuildingNumber(int buildingNumber) {
        this.buildingNumber = buildingNumber;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public MemberInfo setStreet(String street) {
        this.street = street;
        return this;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public MemberInfo setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
        return this;
    }

    public int getTel() {
        return tel;
    }

    public MemberInfo setTel(int tel) {
        this.tel = tel;
        return this;
    }

    public char getEntry_by_car() {
        return entry_by_car;
    }

    public MemberInfo setEntry_by_car(char entry_by_car) {
        this.entry_by_car = entry_by_car;
        return this;
    }

    public String getName() {
        return name;
    }

    public MemberInfo setName(String name) {
        this.name = name;
        return this;
    }

    public String geteMail() {
        return eMail;
    }

    public MemberInfo seteMail(String eMail) {
        this.eMail = eMail;
        return this;
    }

    public int getFlatNumber() {
        return flatNumber;
    }

    public MemberInfo setFlatNumber(int flatNumber) {
        this.flatNumber = flatNumber;
        return this;
    }

    public int getSquare() {
        return square;
    }

    public MemberInfo setSquare(int square) {
        this.square = square;
        return this;
    }

    @Override
    public String toString() {
        return "MemberInfo{" +
                "id=" + id +
                ", flatNumber=" + flatNumber +
                ", numberOfRooms=" + numberOfRooms +
                ", square=" + square +
                ", street='" + street + '\'' +
                ", buildingNumber=" + buildingNumber +
                ", name='" + name + '\'' +
                ", eMail='" + eMail + '\'' +
                ", tel=" + tel +
                ", entry_by_car=" + entry_by_car +
                '}';
    }
}
