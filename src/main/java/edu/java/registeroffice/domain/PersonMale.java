package edu.java.registeroffice.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("2")
public class PersonMale extends Person {

    @OneToMany(mappedBy = "husband", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private List<MarriageCertificate> marriageCertificates;

    @OneToMany(mappedBy = "father", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
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
