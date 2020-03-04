package com.neo4j.service;


import com.neo4j.entity.TableGraph;
import com.neo4j.entity.TableRelationship;

import java.util.List;
import java.util.Map;

public interface Neo4jHandlerService {

    TableGraph saveNeo4jTable(TableGraph tableGraph);

    String saveTableRelationship(TableRelationship tablerel);

    List<Map<String, Object>> findTables(String db, String code);
}
