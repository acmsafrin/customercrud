package com.mycompany.myproject.service;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public class GenericServiceImpl<T, D, ID extends Serializable> implements GenericService<T, D, ID> {

    @Autowired
    private JpaRepository<T, ID> repository;

    @Autowired
    private DozerBeanMapper mapper;

    protected Class<T> entityClass;

    protected Class<D> dtoClass;

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    public GenericServiceImpl() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
        this.dtoClass = (Class<D>) genericSuperclass.getActualTypeArguments()[1];
    }

    public D findOne(ID id) {
        return mapper.map(repository.findOne(id), dtoClass);
    }

    public List<D> findAll() {
        List<D> result = new ArrayList<D>();
        for (T t : repository.findAll()) {
            result.add(mapper.map(t, dtoClass));
        }
        return result;
    }

    
    public T save(D dto) {
        return repository.saveAndFlush(mapper.map(dto, entityClass));

    }

    @Override
    @Transactional
    public void delete(D dto) {
        T newEntity = em.merge(mapper.map(dto, entityClass));
        em.remove(newEntity);
        em.flush();
    }

}
