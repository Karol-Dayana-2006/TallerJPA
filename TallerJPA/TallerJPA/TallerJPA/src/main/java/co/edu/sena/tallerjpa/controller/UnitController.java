/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.tallerjpa.controller;

import co.edu.sena.tallerjpa.model.Unit;
import co.edu.sena.tallerjpa.persistence.DAOFactory;
import co.edu.sena.tallerjpa.persistence.EntityManagerHelper;
import java.util.List;

/**
 * Fecha: 26/04/2025
 * @author Karol Arbelaez
 * Objetivo: Objetivo: implementar la interface para controlar el modelo Unit
 */
public class UnitController implements IUnitController{

    @Override
    public void insert(Unit unit) throws Exception {
        if(unit== null)
        {
            throw new Exception("La unidad es nula");
        }
                  
        if(unit.getIdUnit() == 0)
        {
            throw new Exception("El documento es obligatorio");
        }
        
        if("".equals(unit.getName()))
        {            
            throw new Exception("El nombre es obligatorio");
        }
        
        //insertar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getUnitDAO().insert(unit);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();        
    }


    @Override
    public void update(Unit unit) throws Exception {
        if(unit == null)
        {
            throw new Exception("La unidad es nula");
        }
                  
        if(unit.getIdUnit() == 0)
        {
            throw new Exception("El documento es obligatorio");
        }
        
        if("".equals(unit.getName()))
        {            
            throw new Exception("El nombre es obligatorio");
        }
        
        //consultar si la unidad existe en la bd
        Unit unitExists = DAOFactory.getUnitDAO().findById(unit.getIdUnit());
        if(unitExists == null)
        {
            throw new Exception("La unidad no existe");
        }
        
        //merge: todos los campos menos la PK
        unitExists.setName(unit.getName());
        EntityManagerHelper.beginTransaction();        
        DAOFactory.getUnitDAO().update(unitExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Long id_unit) throws Exception {
        if(id_unit == 0)
        {
            throw new Exception("El documento es obligatorio");
        }
        
        //consultar si la unidad existe en la bd
        Unit unitExists = DAOFactory.getUnitDAO().findById(id_unit);
        if(unitExists == null)
        {
            throw new Exception("La unidad no existe");
        }
        
        //eliminar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getUnitDAO().delete(unitExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public Unit findById(Long id) throws Exception {
        if(id == 0)
        {
            throw new Exception("El documento es obligatorio");
        }
        
        return DAOFactory.getUnitDAO().findById(id);
    }

    @Override
    public List<Unit> findAll() throws Exception {
         return DAOFactory.getUnitDAO().findAll();
    }
    
}
