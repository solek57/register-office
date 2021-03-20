package edu.java.registeroffice.dao;

import edu.java.registeroffice.domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class PersonDao {
    private EntityManager entityManager;

    public PersonDao() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public List<Person> findPersons(){
        return entityManager.createQuery("select p from Person p").getResultList();
    }
}
