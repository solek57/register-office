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

    private boolean active;

    private LocalDate endDate;

    private PersonFemale husband;

    private PersonMale wife;
}
