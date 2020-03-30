package com.neo4j.entity;

public class TableColGraphVo {


    public String db;
    public String code;
    public String name;
    public String business;
    public String fullCode;
    public String col;//目标字段
    public String sourceCol; //源字段
    private String stag; //源对应关系
    private String ttag; //目标对应关系
    private String sname;//源字段名
    private String tname;//目标字段名


    public String getSourceCol() {
        return sourceCol;
    }

    public void setSourceCol(String sourceCol) {
        this.sourceCol = sourceCol;
    }

    public String getCol() {
        return col;
    }

    public void setCol(String col) {
        this.col = col;
    }

    public String getFullCode() {
        return fullCode;
    }

    public void setFullCode(String fullCode) {
        this.fullCode = fullCode;
    }

    public String getStag() {
        return stag;
    }

    public void setStag(String stag) {
        this.stag = stag;
    }

    public String getTtag() {
        return ttag;
    }

    public void setTtag(String ttag) {
        this.ttag = ttag;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
