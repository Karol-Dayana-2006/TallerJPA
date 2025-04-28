/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.tallerjpa.controller;

import co.edu.sena.tallerjpa.model.Category;
import co.edu.sena.tallerjpa.persistence.DAOFactory;
import java.util.List;

/**
 * Fecha:26/04/2025
 * @author Ruben Franco
 * Objetivo: Implementar la interface para controlar el metodo Category
 */
public class CategoryController implements ICategoryController{

    @Override
    public void insert(Category category) throws Exception {
        if(category == null)
        {
            throw new Exception("La Categoria es obligatoria");
        }
        if(category.getIdCategory() == 0)
        {
            throw new Exception("El ID es obligatorio");
        }
        if("".equals(category.getName()))
        {
            throw new Exception("El nombre de la categoria es obligatorio");
        }
        //Insertar
        DAOFactory.getCategoryDAO().insert(category);
    }

    @Override
    public void update(Category category) throws Exception {
        if(category == null)
        {
            throw new Exception("La Categoria es obligatoria");
        }
        if(category.getIdCategory() == 0)
        {
            throw new Exception("El ID es obligatorio");
        }
        if("".equals(category.getName()))
        {
            throw new Exception("El nombre de la categoria es obligatorio");
        }
        //consultar si la categoria existe en la bd
        Category categoryExist = DAOFactory.getCategoryDAO().findById(category.getIdCategory());
        if(categoryExist == null)
        {
            throw new Exception("La categoria no existe");
        }
        //Actualizar
        DAOFactory.getCategoryDAO().update(category);
    }

    @Override
    public void delete(Category category) throws Exception {
        if(category.getIdCategory() == 0)
        {
            throw new Exception("El ID es obligatorio");
        }
        //consultar si la categoria existe en la bd
        Category categoryExist = DAOFactory.getCategoryDAO().findById(category.getIdCategory());
        if(categoryExist == null)
        {
            throw new Exception("La categoria no existe");
        }
        //Actualizar
        DAOFactory.getCategoryDAO().delete(category);
    }

    @Override
    public Category findById(Long id) throws Exception {
        if(id == 0)
        {
            throw new Exception("El ID es obligatorio");
        }
        return DAOFactory.getCategoryDAO().findById(id);
    }

    @Override
    public List<Category> findAll() throws Exception {
        return DAOFactory.getCategoryDAO().findAll();
    }
}
