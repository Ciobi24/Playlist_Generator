package org.example.controllers;


import org.example.exceptions.CreateException;
import org.example.exceptions.DeleteException;
import org.example.exceptions.FindException;
import org.example.exceptions.UpdateException;

import java.util.List;

/**
 * Interface for generic CRUD operations performed by the controllers.
 *
 * @param <T> The object model that corresponds to a database entity
 */
public interface CRUDController<T> {
    /**
     * Inserts a new row in the corresponding table.
     * <p>
     * The newly inserted object doesn't need to have any id value yet.
     * The id is created at the database level and the object gets updated.
     *
     * @param obj The object whose data should be inserted into the database
     * @return The {@code obj} that also stores the id from the database
     * @throws CreateException If there is an SQL related exception in the insert process
     */
    T create(T obj) throws CreateException;

    /**
     * Finds a row in the database corresponding to a given id and stores it as a model object.
     *
     * @param id The id of the database row
     * @return The model found in the database
     * @throws FindException If there is an SQL related exception in the find process
     */
    T findById(int id) throws FindException;

    T findByName(String name) throws FindException;

    List<T> findAll() throws FindException;

    /**
     * Performs a database update based on a given model object
     *
     * @param obj The model that should be updated. The id field is mandatory.
     * @throws UpdateException If there is an SQL related exception in the update process
     */
    void update(T obj) throws UpdateException;

    /**
     * Performs a database deletion based on a given row id
     *
     * @param id The id of the database entity that should be deleted
     * @throws DeleteException If there is an SQL related exception in the deletion process
     */
    void deleteById(int id) throws DeleteException;
}
