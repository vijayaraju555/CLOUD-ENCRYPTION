package com.cloudencryption.model;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Component
@Table(name = "req")
public class FileRequest {

    private int fid;
    private int oid;
    private int uid;

    @Id
    private int reid;

    private String status;


    public FileRequest() {
        //for hibernate to not show error
    }

    public FileRequest(int fid, int oid, int uid) {
        this.fid = fid;
        this.oid = oid;
        this.uid = uid;
        this.status = "pending";
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getReid() {
        return reid;
    }

    public void setReid(int reid) {
        this.reid = reid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
