package com.cloudencryption.dao;

import com.cloudencryption.model.File;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public interface FileDao {

    void saveFile(File file) throws Exception;

    File getFileByName(String name) throws Exception;

    String getEncryptedFileName() throws Exception;

    String getFileKey(String file, String encodedKey) throws NoSuchAlgorithmException;

    String[] getStopWords();

    void saveKeyWord(String encFileName, String fileName) throws Exception;

    File getFileById(int id) throws Exception;

    void setStatus(int id) throws Exception;

}
