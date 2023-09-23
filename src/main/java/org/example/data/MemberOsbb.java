package org.example.data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Table(name = "member_osbb")
@Entity
public class MemberOsbb implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String role;

    public int getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @OneToMany(mappedBy = "member_osbb", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ResidentsRC> residentsRC = new ArrayList<>();

    public List<ResidentsRC> getResidentsRC() {
        return residentsRC;
    }
}
