/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.tallerjpa.persistence;

import co.edu.sena.tallerjpa.model.Person;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Aprendiz
 */
public class PersonDAO implements IPersonDAO{

    @Override
    public void insert(Person person) throws Exception {
        try {
           EntityManagerHelper.getEntityManager().persist(person);
        } catch (RuntimeException e) {
            throw e;
        }   
    }

    @Override
    public void update(Person person) throws Exception {
        try {
           EntityManagerHelper.getEntityManager().merge(person);
        } catch (RuntimeException e) {
            throw e;
        }    
    }

    @Override
    public void delete(Person person) throws Exception {
        try {
           EntityManagerHelper.getEntityManager().remove(person);
        } catch (RuntimeException e) {
            throw e;
        }  
    }

    @Override
    public Person findById(Long id) throws Exception {
        try {
           return EntityManagerHelper.getEntityManager().find(Person.class, id);
        } catch (RuntimeException e) {
            throw e;
        } 
    }

    @Override
    public List<Person> findAll() throws Exception {
        try {
            Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Person.findAll");
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }  
    }
    
}
