package entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Crm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int crmId;

    private String crmName;

    private String crmEmail;

    private String crmPass;

    private String crmPhone;

    private String address;

    @OneToMany(mappedBy = "crm", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User> user ;



    public Crm() {
    }

    public int getCrmId() {
        return crmId;
    }

    public void setCrmId(int crmId) {
        this.crmId = crmId;
    }

    public String getCrmName() {
        return crmName;
    }

    public void setCrmName(String crmName) {
        this.crmName = crmName;
    }

    public String getCrmEmail() {
        return crmEmail;
    }

    public void setCrmEmail(String crmEmail) {
        this.crmEmail = crmEmail;
    }

    public String getCrmPass() {
        return crmPass;
    }

    public void setCrmPass(String crmPass) {
        this.crmPass = crmPass;
    }

    public String getCrmPhone() {
        return crmPhone;
    }

    public void setCrmPhone(String crmPhone) {
        this.crmPhone = crmPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }
}
