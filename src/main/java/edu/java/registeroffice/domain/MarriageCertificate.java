package edu.java.registeroffice.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "ro_marriage_certificate")
@Entity
public class MarriageCertificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "marriage_certificate_id")
    private Long marriageCertificateId;

    @Column(name = "marriage_certificate_number")
    private String marriageCertificateNumber;

    @Column(name = "issue_date")
    private LocalDate issueDate;

    @Column(name = "active")
    private boolean active;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch =  FetchType.LAZY)
    @JoinColumn(name = "husband_id")
    private PersonFemale husband;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch =  FetchType.LAZY)
    @JoinColumn(name = "wife_id")
    private PersonMale wife;

    public String getMarriageCertificateNumber() {
        return marriageCertificateNumber;
    }

    public void setMarriageCertificateNumber(String marriageCertificateNumber) {
        this.marriageCertificateNumber = marriageCertificateNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public PersonFemale getHusband() {
        return husband;
    }

    public void setHusband(PersonFemale husband) {
        this.husband = husband;
    }

    public PersonMale getWife() {
        return wife;
    }

    public void setWife(PersonMale wife) {
        this.wife = wife;
    }
}
