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
    public void  findPersons() {
        for (Person p: personDao.findPersons()) {
            System.out.println(p.getLastName());
        }
    }
}