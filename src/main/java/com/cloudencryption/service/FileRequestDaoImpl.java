package com.cloudencryption.service;

import com.cloudencryption.dao.FileRequestDao;
import com.cloudencryption.model.FileRequest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class FileRequestDaoImpl implements FileRequestDao {
    private Session session;
    private final SessionFactory factory;

    public FileRequestDaoImpl() {
        Configuration config = new Configuration().configure().addAnnotatedClass(FileRequest.class);
        factory = config.buildSessionFactory();
    }


    @Override
    public void addRequest(int fileId, int ownerId, int id) throws Exception {
        session.getTransaction().begin();
        FileRequest request = new FileRequest(fileId, ownerId, id);
        session.save(request);
        session.getTransaction().commit();
        session.close();
    }
}
