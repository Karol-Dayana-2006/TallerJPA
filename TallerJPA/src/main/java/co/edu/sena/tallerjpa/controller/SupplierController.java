/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.tallerjpa.controller;

import co.edu.sena.tallerjpa.model.Supplier;
import co.edu.sena.tallerjpa.persistence.DAOFactory;
import co.edu.sena.tallerjpa.persistence.EntityManagerHelper;
import java.util.List;

/**
 * Fecha: 01/05/2025
 * @author Daniel Ortiz
 * Objective: Implementar la interface para controlar el metodo Supplier
 */
public class SupplierController implements ISupplierController{

    @Override
    public void insert(Supplier supplier) throws Exception {
        if(supplier.getIdUnit() == 0)
        {
            throw new Exception("El id de la persona es obligatorio");
        }
        if("".equals(supplier.getName()))
        {
            throw new Exception("El nombre de la persona es obligatorio");
        }
        if("".equals(supplier.getPhone()))
        {
            throw new Exception("El telefono es obligatorio");
        }
        Supplier suppierExist = DAOFactory.getSupplierDAO().findById(supplier.getIdUnit());
        if(suppierExist != null)
        {
            throw new Exception("Ya existe otra persona con este ID");
        }
        EntityManagerHelper.beginTransaction();
        DAOFactory.getSupplierDAO().insert(supplier);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(Supplier supplier) throws Exception {
        if(supplier.getIdUnit() == 0)
        {
             throw new Exception("El id de la persona es obligatorio");
        }
        if("".equals(supplier.getName()))
        {
            throw new Exception("El nombre de la persona es obligatorio");
        }
        if("".equals(supplier.getPhone()))
        {
            throw new Exception("El telefono es obligatorio");
        }
        Supplier supplierExist = DAOFactory.getSupplierDAO().findById(supplier.getIdUnit());
        if(supplierExist == null)
        {
            throw new Exception("La persona no existe");
        }
        //merge
        supplierExist.setIdUnit(supplier.getIdUnit());
        supplierExist.setName(supplier.getName());
        supplierExist.setPhone(supplier.getPhone());
        EntityManagerHelper.beginTransaction();
        DAOFactory.getSupplierDAO().update(supplierExist);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Long id) throws Exception {
        if(id == 0)
        {
            throw new Exception("El id de la persona es obligatorio");
        }
        Supplier supplierExist = DAOFactory.getSupplierDAO().findById(id);
        if(supplierExist == null)
        {
            throw new Exception("La persona no existe");
        }
        EntityManagerHelper.beginTransaction();
        DAOFactory.getSupplierDAO().delete(supplierExist);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public Supplier findById(Long id) throws Exception {
        if(id == 0)
        {
            throw new Exception("El id de la persona es obligatorio");
        }
        
        return DAOFactory.getSupplierDAO().findById(id);
    }

    @Override
    public List<Supplier> findAll() throws Exception {
        return DAOFactory.getSupplierDAO().findAll();
    }
    
}
