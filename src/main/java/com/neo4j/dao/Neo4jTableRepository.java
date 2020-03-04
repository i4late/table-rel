package com.neo4j.dao;

import com.neo4j.entity.TableGraph;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.Map;

public interface Neo4jTableRepository extends Neo4jRepository<TableGraph, Long> {
    @Query("MATCH (m:TABLE) where m.fullCode={fullCode} RETURN m")
    TableGraph getTable(@Param("fullCode") String fullCode);

    @Query("MATCH (a:TABLE)-[r]-(b:TABLE) WHERE a.fullCode={fullCode} return a.db,a.code,a.name,r.source,b.db,b.code,b.name,r.target ")
    Iterable<Map<String, Object>> findTables(@Param("fullCode") String fullCode);

}
