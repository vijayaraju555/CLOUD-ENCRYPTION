package com.cloudencryption.dao;

import org.springframework.stereotype.Service;

@Service
public interface FileRequestDao {
    void addRequest(int fileId, int ownerId, int id) throws Exception;
}
