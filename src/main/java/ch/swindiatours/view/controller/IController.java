package ch.swindiatours.view.controller;

import java.util.List;

public interface IController<T> {
    //    public void create(T entity);
//
//    public void edit(T entity);
//
//    public void remove(T entity);
//
//    public T find(Object id);
        public List<T> findAll();
}
