package com.cloudencryption.controller;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cloudencryption.model.File;
import com.cloudencryption.service.FileDaoImpl;
import com.cloudencryption.service.FileRequestDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.Blob;
import java.util.Arrays;
import java.util.Base64;

@Controller
public class FileController {

    @Autowired
    private FileDaoImpl fileManager;

    @RequestMapping("/saveFile")
    private String saveFile(HttpServletRequest req, HttpServletResponse res) {
        // saving the file
        try {
            HttpSession session = req.getSession();
            int id = (int) session.getAttribute("id9");
            String fName = req.getParameter("fname");
            String actualFileName = req.getParameter("file");
            String ownerKey = req.getParameter("ownerkey");
            String encFileName = fileManager.getEncryptedFileName();
            String encKey = fileManager.getFileKey(actualFileName,
                    fileManager.getEncryptedFileName());
            File f = new File(fName, actualFileName, encFileName, encKey, ownerKey,
                    String.valueOf(id));
            fileManager.saveKeyWord(encFileName, actualFileName);
            fileManager.saveFile(f);
            res.sendRedirect("/upload.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            return "viewfile.jsp";
        }
        return null;
    }

    @GetMapping("/requestFile/{fid}")
    private String saveStatus(@PathVariable int fid, HttpServletResponse res) throws Exception {
        try {
            fileManager.setStatus(fid);
            res.sendRedirect("/viewfile.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            return "upload.jsp";
        }
        return null;
    }
}
