/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.tallerjpa.controller;

import co.edu.sena.tallerjpa.model.Exit;
import co.edu.sena.tallerjpa.persistence.DAOFactory;
import co.edu.sena.tallerjpa.persistence.EntityManagerHelper;
import java.util.List;

/**
 * Fecha:24/04/2025
 * @author Daniel Albeiro Ortiz Manzanares
 * Objetivo: Implementar la interface para controlar el metodo Exit
 */
public class ExitController implements IExitController{

    @Override
    public void insert(Exit exit) throws Exception {
        if(exit == null)
        {
            throw new Exception("La salida es obligatoria");
        }
        
        if(exit.getIdExit() == 0)
        {
            throw new Exception("El ID de la salida es obligatorio");
        }
        
        if("".equals(exit.getDate()))
        {
            throw new Exception("La fecha es obligatoria");
        }
        if(exit.getQuantity() == 0)
        {
            throw new Exception("La cantidad es obligatoria");
        }
        
        //FKs
        if(exit.getIdArticle() == null)
        {
            throw new Exception("El ID del articulo es obligatorio");
        }
        if(exit.getDocument() == null)
        {
            throw new Exception("la identificación del empleado es obligatorio");
        }
        if(exit.getIdUnit() == null)
        {
            throw new Exception("El ID del producto es obligatorio");
        }
        Exit exitExist = DAOFactory.getExitDAO().findById(exit.getIdExit());
        if(exitExist != null)
        {
            throw new Exception("Ya existe la salida");
        }
        
        //insertar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getExitDAO().insert(exit);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        
    }

    @Override
    public void update(Exit exit) throws Exception {
         if(exit == null)
        {
            throw new Exception("La salida es obligatoria");
        }
        
        if("".equals(exit.getDate()))
        {
            throw new Exception("La fecha es obligatoria");
        }
        if(exit.getQuantity() == 0)
        {
            throw new Exception("La cantidad es obligatoria");
        }
        
        //FKs
        if(exit.getIdArticle() == null)
        {
            throw new Exception("El ID del articulo es obligatorio");
        }
        if(exit.getDocument() == null)
        {
            throw new Exception("la identificación del empleado es obligatorio");
        }
        if(exit.getIdUnit() == null)
        {
            throw new Exception("El ID del producto es obligatorio");
        }
        //consultar si el registro existe en la bd
        Exit exitExists = DAOFactory.getExitDAO().findById(exit.getIdExit());
        if(exitExists == null)
        {
            throw new Exception("La salida no existe");
        }
        //merge
        exitExists.setIdExit(exit.getIdExit());
        exitExists.setDate(exit.getDate());
        exitExists.setQuantity(exit.getQuantity());
        exitExists.setObservations(exit.getObservations());
        exitExists.setIdArticle(exit.getIdArticle());
        exitExists.setDocument(exit.getDocument());
        exitExists.setIdUnit(exit.getIdUnit());
        EntityManagerHelper.beginTransaction();
        DAOFactory.getExitDAO().update(exitExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        
        
    }

    @Override
    public void delete(Long id) throws Exception {
        if(id== 0)
        {
            throw new Exception("El ID es obligatorio");
        }
    
        //consultar si el registro existe en la bd
        Exit exitExists = DAOFactory.getExitDAO().findById(id);
        if(exitExists == null)
        {
            throw new Exception("La salida no existe");
        }
        
        //eliminar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getExitDAO().delete(exitExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public Exit findById(Long id) throws Exception {
        if(id == 0)
        {
            throw new Exception("El ID es obligatorio");
        }
        return DAOFactory.getExitDAO().findById(id);
    }

    @Override
    public List<Exit> findAll() throws Exception {
        return DAOFactory.getExitDAO().findAll();
    }
    
}
