/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.tallerjpa.controller;

import co.edu.sena.tallerjpa.model.Presentation;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IPresentationController {
    public void insert(Presentation presentation) throws Exception;
    public void update(Presentation presentation) throws Exception;
    public void delete(Long id) throws Exception;
    public Presentation findById( Long id) throws Exception;
    public List<Presentation> findAll() throws Exception;
}
