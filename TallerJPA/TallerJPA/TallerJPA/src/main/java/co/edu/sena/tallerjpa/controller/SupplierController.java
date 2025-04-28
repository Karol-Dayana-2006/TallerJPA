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
 * Fecha: 26/04/2025
 * @author Karol Arbelaez
 * Objetivo: Objetivo: implementar la interface para controlar el modelo Supplier
 */
public class SupplierController implements ISupplierController{

    @Override
    public void insert(Supplier supplier) throws Exception {
        if(supplier == null)
        {
            throw new Exception("El proveedor es nulo");
        }
                  
        if(supplier.getIdUnit() == 0)
        {
            throw new Exception("El documento es obligatorio");
        }
        
        if("".equals(supplier.getName()))
        {            
            throw new Exception("El nombre es obligatorio");
        }
        
        if("".equals(supplier.getPhone()))
        {            
            throw new Exception("El teléfono es obligatorio");
        }
        
        //insertar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getSupplierDAO().insert(supplier);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();        
    }

    @Override
    public void update(Supplier supplier) throws Exception {
       if(supplier == null)
        {
            throw new Exception("El proveedor es nulo");
        }
                  
        if(supplier.getIdUnit() == 0)
        {
            throw new Exception("El documento es obligatorio");
        }
        
        if("".equals(supplier.getName()))
        {            
            throw new Exception("El nombre es obligatorio");
        }
        
        if("".equals(supplier.getPhone()))
        {            
            throw new Exception("El teléfono es obligatorio");
        }
        
        //consultar si el proveedor existe en la bd
        Supplier supplierExists = DAOFactory.getSupplierDAO().findById(supplier.getIdUnit());
        if(supplierExists == null)
        {
            throw new Exception("El proveedor no existe");
        }
        
        //merge: todos los campos menos la PK
        supplierExists.setName(supplier.getName());
        EntityManagerHelper.beginTransaction();        
        DAOFactory.getSupplierDAO().update(supplierExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Long id_unit) throws Exception {
        if(id_unit == 0)
        {
            throw new Exception("El documento es obligatorio");
        }
        
        //consultar si el proveedor existe en la bd
        Supplier supplierExists = DAOFactory.getSupplierDAO().findById(id_unit);
        if(supplierExists == null)
        {
            throw new Exception("El proveedor no existe");
        }
        
        //eliminar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getSupplierDAO().delete(supplierExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public Supplier findById(Long id) throws Exception {
        if(id == 0)
        {
            throw new Exception("El documento es obligatorio");
        }
        
        return DAOFactory.getSupplierDAO().findById(id);
    }

    @Override
    public List<Supplier> findAll() throws Exception {
        return DAOFactory.getSupplierDAO().findAll();
    }
    
}
