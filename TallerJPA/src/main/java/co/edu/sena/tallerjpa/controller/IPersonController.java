/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.tallerjpa.controller;

import co.edu.sena.tallerjpa.model.Person;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IPersonController {
    public void insert(Person person) throws Exception;
    public void update(Person person) throws Exception;
    public void delete(Long id) throws Exception;
    public Person findById( Long id) throws Exception;
    public List<Person> findAll() throws Exception;
}
