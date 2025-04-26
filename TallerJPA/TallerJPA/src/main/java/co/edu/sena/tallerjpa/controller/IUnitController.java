/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.tallerjpa.controller;

import co.edu.sena.tallerjpa.model.Unit;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IUnitController {
    public void insert(Unit unit) throws Exception;
    public void update(Unit unit) throws Exception;
    public void delete(Long id_unit) throws Exception;
    public Unit findById( Long id) throws Exception;
    public List<Unit> findAll() throws Exception;
}
