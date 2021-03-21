package edu.java.registeroffice.dao;

import edu.java.registeroffice.domain.Person;
import org.junit.Before;
import org.junit.Test;

public class PersonDaoTest {

    PersonDao personDao;

    @Before
    public void init() {
        this.personDao = new PersonDao();
    }

    @Test
    public void findPersons() {
        for (Person p : personDao.findPersons()) {
            System.out.println(p.getFirstName());
            System.out.println(p.getLastName());
            System.out.println(p.getPassports().toString());
            if (p.getBirthCertificate() != null)
                System.out.println(p.getBirthCertificate().getCertificateNumber());
        }
    }
}