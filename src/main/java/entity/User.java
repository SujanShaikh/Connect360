package entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    private String email;

    private String password;

    private String fullName;

    private String phone;

    private String gender;

    private String dob;

    private String address;

    @ManyToOne
    private Crm crm;
    @OneToMany(mappedBy = "user")
    private List<Issue> issue ;


    public Crm getCrm() {
        return crm;
    }

    public void setCrm(Crm crm) {
        this.crm = crm;
    }

    public List<Issue> getIssue() {
        return issue;
    }

    public void setIssue(List<Issue> issue) {
        this.issue = issue;
    }

    public User() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
