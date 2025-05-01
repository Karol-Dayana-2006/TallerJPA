/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.tallerjpa.controller;

import co.edu.sena.tallerjpa.model.Exit;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IExitController {
    public void insert(Exit exit) throws Exception;
    public void update(Exit exit) throws Exception;
    public void delete(Long id) throws Exception;
    public Exit findById( Long id) throws Exception;
    public List<Exit> findAll() throws Exception;
}
