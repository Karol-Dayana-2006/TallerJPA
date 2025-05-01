/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.tallerjpa.controller;

import co.edu.sena.tallerjpa.model.Entry;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IEntryController {
    public void insert(Entry entry) throws Exception;
    public void update(Entry entry) throws Exception;
    public void delete(Long id) throws Exception;
    public Entry findById( Long id) throws Exception;
    public List<Entry> findAll() throws Exception;
}
