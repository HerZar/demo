package com.afiliates.demo.services;

import org.springframework.stereotype.Component;

import java.util.List;

public interface IAfiliateService <T> {

    public List<T> findAll();

    public  T findById (Long idKey);

    public void save(T model);

    public void delete(Long idKey);

}
