package edu.java.registeroffice.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("1")
public class PersonFemale extends Person {

    @OneToMany(mappedBy = "wife", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private List<MarriageCertificate> marriageCertificates;

    @OneToMany(mappedBy = "mother", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private List<BirthCertificate> birthCertificates;

    public List<MarriageCertificate> getMarriageCertificates() {
        return marriageCertificates;
    }

    public void setMarriageCertificates(List<MarriageCertificate> marriageCertificates) {
        this.marriageCertificates = marriageCertificates;
    }

    public List<BirthCertificate> getBirthCertificates() {
        return birthCertificates;
    }

    public void setBirthCertificates(List<BirthCertificate> birthCertificates) {
        this.birthCertificates = birthCertificates;
    }
}
