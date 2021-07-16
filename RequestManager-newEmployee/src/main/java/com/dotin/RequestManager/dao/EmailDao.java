package com.dotin.RequestManager.dao;

import com.dotin.RequestManager.entity.Email;

import java.util.List;

public class EmailDao extends GenericDaoImpl<Email, Long> {
    public List<Email> findAllByReceiverId(Long receiverId) {
        return (List<Email>) getCurrentSession()
                .createQuery("select e FROM Email e INNER JOIN e.recivers r where r.id =:receiver")
                .setParameter("receiver", receiverId)
                .getResultList();
    }

    public List<Email> findAllBySenderId(Long senderId) {
        return (List<Email>) getCurrentSession()
                .createQuery("FROM Email e where sender.id =:sender")
                .setParameter("sender", senderId)
                .getResultList();
    }

}
