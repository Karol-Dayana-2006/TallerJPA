/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.tallerjpa.controller;

import co.edu.sena.tallerjpa.model.Article;
import co.edu.sena.tallerjpa.persistence.DAOFactory;
import co.edu.sena.tallerjpa.persistence.EntityManagerHelper;
import java.util.List;

/**
 * Date: 27/04/2025
 * @author Ruben Franco
 * Objective: Implementar la interface para controlar el metodo Article
 */
public class ArticleController implements IArticleController {

    @Override
    public void insert(Article article) throws Exception {
        if(article == null)
        {
            throw new Exception("El artículo es nulo");
        }
        
        if("".equals(article.getName()))
        {            
            throw new Exception("El nombre del artículo es obligatorio");
        }
                  
        if(article.getQuantity()== 0)
        {
            throw new Exception("El artículo es obligatorio");
        }
        
        if("".equals(article.getPhoto()))
        {            
            throw new Exception("La foto del artículo es obligatoria");
        }
        
        if("".equals(article.getTechnicalSheet()))
        {            
            throw new Exception("La ficha técnica es obligatoria");
        }
        
        //FK
        if(article.getIdPresentation()== null)
        {
            throw new Exception("El id del artículo es obligatorio");
        }
        
        if(article.getIdCategory()== null)
        {
            throw new Exception("El id de la categoría del artículo es obligatoria");
        }
        
        if(article.getIdCategory()== null)
        {
            throw new Exception("El id del proveedor es obligatorio");
        }
        
        //La PK no es autoincremental, se debe validar existencia del empleado
        Article articleExists = DAOFactory.getArticleDAO().findById(article.getIdArticle());
        if(articleExists != null)
        {
            throw new Exception("Ya existe un artículo con ese id");
        }
        
        EntityManagerHelper.beginTransaction();
        DAOFactory.getArticleDAO().insert(article);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(Article article) throws Exception {
        if(article == null)
        {
            throw new Exception("El artículo es nulo");
        }
        
        if("".equals(article.getName()))
        {            
            throw new Exception("El nombre del artículo es obligatorio");
        }
                  
        if(article.getQuantity()== 0)
        {
            throw new Exception("El artículo es obligatorio");
        }
        
        if("".equals(article.getPhoto()))
        {            
            throw new Exception("La foto del artículo es obligatoria");
        }
        
        if("".equals(article.getTechnicalSheet()))
        {            
            throw new Exception("La ficha técnica es obligatoria");
        }
        
        //FK
        if(article.getIdPresentation()== null)
        {
            throw new Exception("El id del artículo es obligatorio");
        }
        
        if(article.getIdCategory()== null)
        {
            throw new Exception("El id de la categoría del artículo es obligatoria");
        }
        
        if(article.getIdCategory()== null)
        {
            throw new Exception("El id del proveedor es obligatorio");
        }
        
        //La PK no es autoincremental, se debe validar existencia del empleado
        Article articleExists = DAOFactory.getArticleDAO().findById(article.getIdArticle());
        if(articleExists != null)
        {
            throw new Exception("No existe el artículo");
        }
        
        //merge
        articleExists.setName(article.getName());
        articleExists.setQuantity(article.getQuantity());
        articleExists.setPhoto(article.getPhoto());
        articleExists.setTechnicalSheet(article.getTechnicalSheet());
        articleExists.setIdPresentation(article.getIdPresentation());
        articleExists.setIdCategory(article.getIdCategory());
        articleExists.setIdSupplier(article.getIdSupplier());
        EntityManagerHelper.beginTransaction();
        DAOFactory.getArticleDAO().update(articleExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }


    @Override
    public void delete(Long id) throws Exception {
        if (id == 0)
            {
            throw new Exception("El id del artículo es obligatorio");
            }
        
        Article articleExists = DAOFactory.getArticleDAO().findById(id);
        if (articleExists == null)
        {
            throw new Exception("No existe el artículo");
        }
        
        EntityManagerHelper.beginTransaction();
        DAOFactory.getArticleDAO().delete(articleExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public Article findById(Long id) throws Exception {
        if(id == 0)
        {
            throw new Exception("El id del artículo es obligatorio");
        }
        
        return DAOFactory.getArticleDAO().findById(id);
    }

    @Override
    public List<Article> findAll() throws Exception {
        return DAOFactory.getArticleDAO().findAll();
    }
    
}
