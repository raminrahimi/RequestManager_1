package com.dotin.RequestManager.dao;

import com.dotin.RequestManager.entity.CategoryElement;

public class CategoryElementDao extends GenericDaoImpl<CategoryElement, Long> {

    public CategoryElement findByCode(Long code) {
        return (CategoryElement) getCurrentSession()
                .createQuery("FROM CategoryElement ce WHERE ce.code = :code")
                .setParameter("code", code)
                .uniqueResult();
    }

}
