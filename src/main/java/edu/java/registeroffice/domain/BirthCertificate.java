package edu.java.registeroffice.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "ro_birth_certificate")
@Entity
public class BirthCertificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "birth_certificate_id")
    private Long birthCertificateId;

    @Column(name = "certificate_number")
    private String certificateNumber;

    @Column(name = "issue_date")
    private LocalDate issueDate;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "father_id")
    private PersonFemale father;

    @ManyToOne
    @JoinColumn(name = "mother_id")
    private PersonMale mother;


    public BirthCertificate() {
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public PersonFemale getFather() {
        return father;
    }

    public void setFather(PersonFemale father) {
        this.father = father;
    }

    public PersonMale getMother() {
        return mother;
    }

    public void setMother(PersonMale mother) {
        this.mother = mother;
    }
}
