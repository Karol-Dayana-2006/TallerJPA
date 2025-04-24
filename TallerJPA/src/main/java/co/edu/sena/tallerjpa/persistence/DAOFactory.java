/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.tallerjpa.persistence;

/**
 *
 * @author Aprendiz
 * Objetivo: instanciar los DAO'S creados en la persistencia
 */
public class DAOFactory {
    private static IArticleDAO articleDAO = new ArticleDAO ();
    private static ICategoryDAO categoryDAO = new CategoryDAO() ;
    private static IEntryDAO entryDAO = new EntryDAO();
    private static IExitDAO exitDAO = new ExitDAO(); 
    private static IPersonDAO personDAO = new PersonDAO(); 
    private static IPresentationDAO presentationDAO = new PresentationDAO(); 
    private static ISupplierDAO supplierDAO = new SupplierDAO(); 
    private static IUnitDAO unitDAO = new UnitDAO(); 

    public static IArticleDAO getArticleDAO() {
        return articleDAO;
    }

    public static ICategoryDAO getCategoryDAO() {
        return categoryDAO;
    }

    public static IEntryDAO getEntryDAO() {
        return entryDAO;
    }

    public static IExitDAO getExitDAO() {
        return exitDAO;
    }

    public static IPersonDAO getPersonDAO() {
        return personDAO;
    }

    public static IPresentationDAO getPresentationDAO() {
        return presentationDAO;
    }

    public static ISupplierDAO getSupplierDAO() {
        return supplierDAO;
    }

    public static IUnitDAO getUnitDAO() {
        return unitDAO;
    }
 
}
