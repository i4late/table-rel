package com.neo4j.dao;

import com.neo4j.entity.TableRelationship;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface Neo4jRelationshipRepository extends Neo4jRepository<TableRelationship, Long> {
    @Query("MATCH (a:TABLE),(b:TABLE) WHERE id(a)={sourceId} AND id(b)={targetId} CREATE (a)-[r:rel {source:{sourceCol},target:{targetCol}}] -> (b) return r.source+\"-\"+r.target ")
    String saveRel(@Param("sourceId") Long sourceId, @Param("targetId") Long targetId, @Param("sourceCol") String sourceCol, @Param("targetCol") String targetCol);

    @Query("MATCH (a:TABLE),(b:TABLE) WHERE id(a)={sourceId} AND id(b)={targetId} CREATE (a)-[r:rel {source:{sourceCol},target:{targetCol},stag:{sourceTag},ttag:{targetTag},sname:{sourceName},tname:{targetName}}] -> (b) return r.source+\"-\"+r.target ")
    String saveRelNameWithTag(@Param("sourceId") Long sourceId, @Param("targetId") Long targetId, @Param("sourceCol") String sourceCol, @Param("targetCol") String targetCol, @Param("sourceTag") String sourceTag,
                      @Param("targetTag") String targetTag, @Param("sourceName") String sourceName, @Param("targetName") String targetName);

}
