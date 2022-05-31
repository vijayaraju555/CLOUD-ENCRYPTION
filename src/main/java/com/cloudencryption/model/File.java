package com.cloudencryption.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name = "upload")
public class File {

    @Id
    @Column(name = "fid")
    private int id;

    @Column(name = "fname")
    private String name;

    @Column(name = "actualfname")
    private String actualName;

    @Column(name = "encryptedfilename")
    private String encryptedName;

    @Column(name = "skeygenerated")
    private String keyGenerated;

    @Column(name = "skeyownergenerated")
    private String keyGeneratedByOwner;

    private String uid;
    private Boolean share;

    public File() {
        //for hibernate to not show error there must be a default constructor
    }

    public File(String name, String actualName, String encryptedName, String keyGenerated, String keyGeneratedByOwner, String uid) {
        this.name = name;
        this.actualName = actualName;
        this.encryptedName = encryptedName;
        this.keyGenerated = keyGenerated;
        this.keyGeneratedByOwner = keyGeneratedByOwner;
        this.uid = uid;
        this.share = Boolean.FALSE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActualName() {
        return actualName;
    }

    public void setActualName(String actualName) {
        this.actualName = actualName;
    }

    public String getEncryptedName() {
        return encryptedName;
    }

    public void setEncryptedName(String encryptedName) {
        this.encryptedName = encryptedName;
    }

    public String getKeyGenerated() {
        return keyGenerated;
    }

    public void setKeyGenerated(String keyGenerated) {
        this.keyGenerated = keyGenerated;
    }

    public String getKeyGeneratedByOwner() {
        return keyGeneratedByOwner;
    }

    public void setKeyGeneratedByOwner(String keyGeneratedByOwner) {
        this.keyGeneratedByOwner = keyGeneratedByOwner;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Boolean getShare() {
        return share;
    }

    public void setShare(Boolean share) {
        this.share = share;
    }
}
