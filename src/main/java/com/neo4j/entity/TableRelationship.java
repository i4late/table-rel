package com.neo4j.entity;

import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "rel")
public class TableRelationship {

    @Id
    @GeneratedValue
    Long id;

    private String source;
    private String target;
    private String stag;
    private String ttag;
    private String sname;
    private String tname;

    @StartNode
    private TableGraph startTable;
    @EndNode
    private TableGraph endTable;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public TableGraph getStartTable() {
        return startTable;
    }

    public void setStartTable(TableGraph startTable) {
        this.startTable = startTable;
    }

    public TableGraph getEndTable() {
        return endTable;
    }

    public void setEndTable(TableGraph endTable) {
        this.endTable = endTable;
    }
}
