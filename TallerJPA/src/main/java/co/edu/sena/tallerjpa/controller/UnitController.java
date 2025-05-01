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
 * Fecha: 01/05/2025
 * @author Daniel Ortiz
 * Objective: Implementar la interface para controlar el metodo Unit
 */
public class UnitController implements IUnitController{

    @Override
    public void insert(Unit unit) throws Exception {
        if(unit.getIdUnit() == 0)
        {
            throw new Exception("El ID es obligatorio");
        }
        if("".equals(unit.getName()))
        {
            throw new Exception("El Nombre es obligatorio");
        }
        Unit unitExist = DAOFactory.getUnitDAO().findById(unit.getIdUnit());
        if(unitExist != null)
        {
            throw new Exception("Ya existe la unidad");
        }
        EntityManagerHelper.beginTransaction();
        DAOFactory.getUnitDAO().insert(unit);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(Unit unit) throws Exception {
        if(unit.getIdUnit() == 0)
        {
            throw new Exception("El ID es obligatorio");
        }
        if("".equals(unit.getName()))
        {
            throw new Exception("El Nombre es obligatorio");
        }
        Unit unitExist = DAOFactory.getUnitDAO().findById(unit.getIdUnit());
        if(unitExist == null)
        {
            throw new Exception("No existe la unidad");
        }
        unitExist.setIdUnit(unit.getIdUnit());
        unitExist.setName(unit.getName());
        EntityManagerHelper.beginTransaction();
        DAOFactory.getUnitDAO().update(unitExist);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Long id) throws Exception {
        if(id == null)
        {
            throw new Exception("El ID es obligatorio");
        }
        Unit unitExist = DAOFactory.getUnitDAO().findById(id);
        if(unitExist == null)
        {
            throw new Exception("No existe la unidad");
        }
        EntityManagerHelper.beginTransaction();
        DAOFactory.getUnitDAO().delete(unitExist);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public Unit findById(Long id) throws Exception {
        if(id == 0)
        {
            throw new Exception("El ID es obligatorio");
        }
        return DAOFactory.getUnitDAO().findById(id);
    }

    @Override
    public List<Unit> findAll() throws Exception {
        return DAOFactory.getUnitDAO().findAll();
    }
    
}
