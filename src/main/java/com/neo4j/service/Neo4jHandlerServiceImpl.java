package com.neo4j.service;

import com.google.common.collect.Lists;
import com.neo4j.dao.Neo4jRelationshipRepository;
import com.neo4j.dao.Neo4jTableRepository;
import com.neo4j.entity.TableGraph;
import com.neo4j.entity.TableRelationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class Neo4jHandlerServiceImpl implements Neo4jHandlerService {
    @Autowired
    private Neo4jTableRepository neo4jTableRepository;
    @Autowired
    private Neo4jRelationshipRepository neo4jRelationshipRepository;

    @Override
    public TableGraph saveNeo4jTable(TableGraph neo4jTableEntity) {
        TableGraph table = getTableByFullCode(neo4jTableEntity);
        if (null == table) {
            TableGraph graph = neo4jTableRepository.save(neo4jTableEntity);
            return graph;
        } else {
            return table;
        }
    }

    public TableGraph getTableByFullCode(TableGraph neo4jTableEntity) {
        TableGraph table = neo4jTableRepository.getTable(neo4jTableEntity.db + "." + neo4jTableEntity.code);
        return table;
    }

    @Override
    public String saveTableRelationship(TableRelationship tablerel) {

        TableGraph startGraph = saveNeo4jTable(tablerel.getStartTable());
        TableGraph endGraph = saveNeo4jTable(tablerel.getEndTable());
        String relation = neo4jRelationshipRepository.saveRel(startGraph.getId(), endGraph.getId(), tablerel.getSource(), tablerel.getTarget());
        return relation;
    }
    @Override
    public String saveTableRelationshipWithNameTag(TableRelationship tablerel) {
        TableGraph startGraph = saveNeo4jTable(tablerel.getStartTable());
        TableGraph endGraph = saveNeo4jTable(tablerel.getEndTable());
        String relation = neo4jRelationshipRepository.saveRelNameWithTag(startGraph.getId(), endGraph.getId(),
                tablerel.getSource(), tablerel.getTarget(),tablerel.getStag(),tablerel.getTtag(),tablerel.getSname(),tablerel.getTname());
        return relation;
    }
    @Override
    public List<Map<String, Object>> findTables(String db, String code) {
        ArrayList<Map<String, Object>> relsTmp = Lists.newArrayList(neo4jTableRepository.findTables(db + "." + code));
        return relsTmp;
    }

}
