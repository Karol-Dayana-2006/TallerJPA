/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.tallerjpa.controller;

import co.edu.sena.tallerjpa.model.Category;
import co.edu.sena.tallerjpa.persistence.DAOFactory;
import co.edu.sena.tallerjpa.persistence.EntityManagerHelper;
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
        //consultar si la categoria existe en la bd
        Category categoryExist = DAOFactory.getCategoryDAO().findById(category.getIdCategory());
        if(categoryExist != null)
        {
            throw new Exception("La categoria ya existe");
        }
        
        //Insertar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getCategoryDAO().insert(category);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
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
        //merge
        categoryExist.setName(category.getName());
        categoryExist.setDescription(category.getDescription());
        EntityManagerHelper.beginTransaction();
        DAOFactory.getCategoryDAO().update(categoryExist);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Long id) throws Exception {
        if(id == 0)
        {
            throw new Exception("El ID es obligatorio");
        }
        //consultar si la categoria existe en la bd
        Category categoryExist = DAOFactory.getCategoryDAO().findById(id);
        if(categoryExist == null)
        {
            throw new Exception("La categoria no existe");
        }
        //Eliminar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getCategoryDAO().delete(categoryExist);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
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
