package com.mycompany.myproject.service;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

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
        javax.persistence.criteria.CriteriaBuilder cb = em.getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery<T> cq = cb.createQuery(entityClass);
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        ParameterExpression<String> p = cb.parameter(String.class);
        Predicate predicateRetired = cb.equal(rt.<Boolean>get("retired"), false);
        cq.where(predicateRetired);
        for (T t : em.createQuery(cq).getResultList()) {
            result.add(mapper.map(t, dtoClass));
        }
        return result;
    }

    public T save(D dto) {        
      return repository.saveAndFlush(mapper.map(dto, entityClass));
      
    }
    
    

}
