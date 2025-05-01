/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.tallerjpa.controller;

import co.edu.sena.tallerjpa.model.Supplier;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface ISupplierController {
    public void insert(Supplier supplier) throws Exception;
    public void update(Supplier supplier) throws Exception;
    public void delete(Long id) throws Exception;
    public Supplier findById( Long id) throws Exception;
    public List<Supplier> findAll() throws Exception;
}
