package com.neo4j.entity;

import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "rel")
public class TableRelationship {

    @Id
    @GeneratedValue
    Long id;

    private String source;
    private String target;

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
