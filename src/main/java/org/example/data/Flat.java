package org.example.data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Table(name = "flats")
@Entity
public class Flat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "flat_number")
    private int flatNumber;
    @Column(name = "number_of_rooms")
    private int numberOfRooms;
    private int square;

    public int getId() {
        return id;
    }

    public int getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(int flatNumber) {
        this.flatNumber = flatNumber;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "building_id")
    private Building building;

    public void setBuilding(Building building) {
        this.building = building;
    }

    @ManyToMany
    @JoinTable(
            name = "ownership",
            joinColumns = @JoinColumn(name = "flats_id"),
            inverseJoinColumns = @JoinColumn(name = "residents_RC_id")
    )
    private List<ResidentsRC> residentsRCList = new ArrayList<>();

    public void setResidentsRCList(List<ResidentsRC> residentsRCList) {
        this.residentsRCList = residentsRCList;
    }
}
