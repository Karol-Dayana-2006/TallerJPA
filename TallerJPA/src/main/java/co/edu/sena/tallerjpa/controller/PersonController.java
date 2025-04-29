/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.tallerjpa.controller;

import co.edu.sena.tallerjpa.model.Person;
import co.edu.sena.tallerjpa.persistence.DAOFactory;
import co.edu.sena.tallerjpa.persistence.EntityManagerHelper;
import java.util.List;

/**
 * Fecha:24/04/2025
 * @author Daniel Albeiro Ortiz Manzanares
 * Objetivo: Implementar la interface para controlar el metodo person
 */
public class PersonController implements IPersonController{

    @Override
    public void insert(Person person) throws Exception {
        if(person == null)
        {
            throw new Exception("El empleado es obligatorio");
        }
        if(person.getDocument() == 0)
        {
            throw new Exception("El documento es obligatorio");
        }
        if("".equals(person.getPhone()))
        {
            throw new Exception("El telefono es obligatorio");
        }
        if("".equals(person.getName()))
        {
            throw new Exception("El nombre es obligatorio");
        }
        
        //insertar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getPersonDAO().update(person);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        
        
    }

    @Override
    public void update(Person person) throws Exception {
        if(person == null)
        {
            throw new Exception("El empleado es obligatorio");
        }
        if(person.getDocument() == 0)
        {
            throw new Exception("El documento es obligatorio");
        }
        if("".equals(person.getPhone()))
        {
            throw new Exception("El telefono es obligatorio");
        }
        if("".equals(person.getName()))
        {
            throw new Exception("El nombre es obligatorio");
        }
         
        Person personExists = DAOFactory.getPersonDAO().findById(person.getDocument());
        if(personExists == null)
        {
            throw new Exception("El empleado no existe");
        }
        //merge
        personExists.setPhone(person.getPhone());
        personExists.setName(person.getName());
        EntityManagerHelper.beginTransaction();
        DAOFactory.getPersonDAO().update(person);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Long id) throws Exception {
        if(id == 0)
        {
            throw new Exception("El documento es obligatorio");
        }
        Person personExists = DAOFactory.getPersonDAO().findById(id);
        if(personExists == null)
        {
            throw new Exception("El empleado no existe");
        }
        //eliminar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getPersonDAO().delete(personExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public Person findById(Long id) throws Exception {
        if(id == 0)
        {
            throw new Exception("El ID es obligatorio");
        }
        return DAOFactory.getPersonDAO().findById(id);
    }

    @Override
    public List<Person> findAll() throws Exception {
        return DAOFactory.getPersonDAO().findAll();
    }
    
}
