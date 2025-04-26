/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.tallerjpa.controller;

import co.edu.sena.tallerjpa.model.Presentation;
import co.edu.sena.tallerjpa.persistence.DAOFactory;
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
        //Insertar
        DAOFactory.getPresentationDAO().insert(presentation);
            
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
            throw new Exception("La presentación no existe");
        }
        
        //Actualizar
        DAOFactory.getPresentationDAO().update(presentation);
    }

    @Override
    public void delete(Presentation presentation) throws Exception {
        if(presentation.getIdPresentation() == 0)
        {
            throw new Exception("El ID es obligatorio");
        }
        Presentation presentationExist = DAOFactory.getPresentationDAO().findById(presentation.getIdPresentation());
        if(presentationExist == null)
        {
            throw new Exception("La presentación no existe");
        }
        
        //Actualizar
        DAOFactory.getPresentationDAO().delete(presentation);
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
