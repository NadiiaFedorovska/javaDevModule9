package org.example.data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Table(name = "residents_rc")
@Entity
public class ResidentsRC implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int tel;
    @Column(name = "e_mail")
    private String eMail;
    private char entry_by_car;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public char getEntry_by_car() {
        return entry_by_car;
    }

    public void setEntry_by_car(char entry_by_car) {
        this.entry_by_car = entry_by_car;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_osbb_id")
    private MemberOsbb member_osbb;

    public void setMember_osbb(MemberOsbb member_osbb) {
        this.member_osbb = member_osbb;
    }

    @ManyToMany(mappedBy = "residentsRCList", cascade = CascadeType.ALL)
    private List<Flat> flatList = new ArrayList<>();

    public void setFlatList(List<Flat> flatList) {
        this.flatList = flatList;
    }
}
