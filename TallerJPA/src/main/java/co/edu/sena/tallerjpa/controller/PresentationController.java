/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.tallerjpa.controller;

import co.edu.sena.tallerjpa.model.Presentation;
import co.edu.sena.tallerjpa.persistence.DAOFactory;
import co.edu.sena.tallerjpa.persistence.EntityManagerHelper;
import java.util.List;

/**
 * Fecha:24/04/2025
 * @author Daniel Albeiro Ortiz Manzanares
 * Objetivo: Implementar la interface para controlar el metodo presentation
 */
public class PresentationController implements IPresentationController{

    @Override
    public void insert(Presentation presentation) throws Exception {
        if(presentation == null) 
        {
            throw new Exception("La presentacion es obligatoria");
        }
        if(presentation.getIdPresentation() == 0) 
        {
            throw new Exception("El ID es obligatorio");
        }
        if("".equals(presentation.getDescription()))
        {
            throw new Exception("la descripción es obligatoria");
        }
        Presentation presentationExist = DAOFactory.getPresentationDAO().findById(presentation.getIdPresentation());
        if(presentationExist != null)
        {
            throw new Exception("La presentacion ya existe");
        }
        //insertar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getPresentationDAO().insert(presentation);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
            
    }

    @Override
    public void update(Presentation presentation) throws Exception {
        if(presentation == null) 
        {
            throw new Exception("La presentacion es obligatoria");
        }
        if(presentation.getIdPresentation() == 0) 
        {
            throw new Exception("El ID es obligatorio");
        }
        if("".equals(presentation.getDescription()))
        {
            throw new Exception("la descripción es obligatoria");
        }
        
        Presentation presentationExist = DAOFactory.getPresentationDAO().findById(presentation.getIdPresentation());
        if(presentationExist == null)
        {
            throw new Exception("La presentacion no existe");
        }
        //merge
        presentationExist.setIdPresentation(presentation.getIdPresentation());
        presentationExist.setDescription(presentation.getDescription());
        EntityManagerHelper.beginTransaction();
        DAOFactory.getPresentationDAO().update(presentationExist);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Long id) throws Exception {
        if(id == 0)
        {
            throw new Exception("El ID es obligatorio");
        }
        Presentation presentationExist = DAOFactory.getPresentationDAO().findById(id);
        if(presentationExist == null)
        {
            throw new Exception("La presentación no existe");
        }
        
        //Eliminar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getPresentationDAO().delete(presentationExist);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public Presentation findById(Long id) throws Exception {
        if(id == 0)
        {
            throw new Exception("El ID es obligatorio");
        }
        return DAOFactory.getPresentationDAO().findById(id);
    }

    @Override
    public List<Presentation> findAll() throws Exception {
        return DAOFactory.getPresentationDAO().findAll();
    }
    
}
