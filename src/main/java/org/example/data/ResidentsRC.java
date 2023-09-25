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
    @Column(name = "id")
    private int residentsRCId;
    private String name;
    private int tel;
    @Column(name = "e_mail")
    private String eMail;
    @Column(name = "entry_by_car")
    private char entryByCar;

    public int getResidentsRCId() {
        return residentsRCId;
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

    public char getEntryByCar() {
        return entryByCar;
    }

    public void setEntryByCar(char entryByCar) {
        this.entryByCar = entryByCar;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_osbb_id")
    private MemberOsbb memberOsbb;

    public void setMemberOsbb(MemberOsbb memberOsbb) {
        this.memberOsbb = memberOsbb;
    }

    @ManyToMany(mappedBy = "residentsRC", cascade = CascadeType.ALL)
    private List<Flat> flat = new ArrayList<>();

    public void setFlat(List<Flat> flat) {
        this.flat = flat;
    }
}
