/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.tallerjpa.persistence;

import co.edu.sena.tallerjpa.model.Presentation;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Aprendiz
 */
public class PresentationDAO implements IPresentationDAO{

    @Override
    public void insert(Presentation presentation) throws Exception {
        try {
           EntityManagerHelper.getEntityManager().persist(presentation);
        } catch (RuntimeException e) {
            throw e;
        }   
    }

    @Override
    public void update(Presentation presentation) throws Exception {
        try {
           EntityManagerHelper.getEntityManager().merge(presentation);
        } catch (RuntimeException e) {
            throw e;
        }   
    }

    @Override
    public void delete(Presentation presentation) throws Exception {
        try {
           EntityManagerHelper.getEntityManager().remove(presentation);
        } catch (RuntimeException e) {
            throw e;
        }  
    }

    @Override
    public Presentation findById(Long id) throws Exception {
        try {
           return EntityManagerHelper.getEntityManager().find(Presentation.class, id);
        } catch (RuntimeException e) {
            throw e;
        }   
    }

    @Override
    public List<Presentation> findAll() throws Exception {
        try {
            Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Presentation.findAll");
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }    
    }
    
}
