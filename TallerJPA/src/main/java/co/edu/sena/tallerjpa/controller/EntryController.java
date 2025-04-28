/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.tallerjpa.controller;

import co.edu.sena.tallerjpa.model.Entry;
import co.edu.sena.tallerjpa.persistence.DAOFactory;
import java.util.List;

/**
 * Fecha:26/04/2025
 * @author Ruben Franco
 * Objetivo: Implementar la interface para controlar el metodo Entry
 */
public class EntryController implements IEntryController{

    @Override
    public void insert(Entry entry) throws Exception {
        if(entry == null)
        {
            throw new Exception("La entrada es obligatoria");
        }
        if(entry.getIdEntry() == 0)
        {
            throw new Exception("El ID es obligatorio");
        }
        if("".equals(entry.getDate()))
        {
            throw new Exception("La fecha es obligatoria");
        }
        if(entry.getQuantity() == 0)
        {
            throw new Exception("La cantida es obligatoria");
        }
        
        //fks
        if(entry.getIdArticle() == null)
        {
            throw new Exception("El ID del articulo es obligatorio");
        }
        //Insertar
        DAOFactory.getEntryDAO().insert(entry);
    }

    @Override
    public void update(Entry entry) throws Exception {
        if(entry == null)
        {
            throw new Exception("La entrada es obligatoria");
        }
        if(entry.getIdEntry() == 0)
        {
            throw new Exception("El ID es obligatorio");
        }
        if("".equals(entry.getDate()))
        {
            throw new Exception("La fecha es obligatoria");
        }
        if(entry.getQuantity() == 0)
        {
            throw new Exception("La cantida es obligatoria");
        }
        
        //fks
        if(entry.getIdArticle() == null)
        {
            throw new Exception("El ID del articulo es obligatorio");
        }
        //consultar si la entrada existe en la bd
        Entry entryExist = DAOFactory.getEntryDAO().findById(entry.getIdEntry());
        if(entryExist == null)
        {
            throw new Exception("La entrada no existe");
        }
        //actualizar
        DAOFactory.getEntryDAO().update(entry);
    }

    @Override
    public void delete(Entry entry) throws Exception {
        if(entry.getIdEntry() == 0)
        {
            throw new Exception("El ID es obligatorio");
        }
        //consultar si la entrada existe en la bd
        Entry entryExist = DAOFactory.getEntryDAO().findById(entry.getIdEntry());
        if(entryExist == null)
        {
            throw new Exception("La entrada no existe");
        }
        //eliminar
        DAOFactory.getEntryDAO().delete(entry);
        
    }

    @Override
    public Entry findById(Long id) throws Exception {
        if(id == 0)
        {
            throw new Exception("El ID es obligatorio");
        }
        return DAOFactory.getEntryDAO().findById(id);
    }

    @Override
    public List<Entry> findAll() throws Exception {
        return DAOFactory.getEntryDAO().findAll();
    }
}
