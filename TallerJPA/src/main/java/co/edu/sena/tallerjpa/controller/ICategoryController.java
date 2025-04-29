/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.tallerjpa.controller;

import co.edu.sena.tallerjpa.model.Category;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface ICategoryController {
    public void insert(Category category) throws Exception;
    public void update(Category category) throws Exception;
    public void delete(Long id) throws Exception;
    public Category findById( Long id) throws Exception;
    public List<Category> findAll() throws Exception;
}
