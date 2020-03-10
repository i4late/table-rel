package com.neo4j.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.neo4j.entity.TableColGraph;
import com.neo4j.entity.TableGraph;
import com.neo4j.entity.TableRelationship;
import com.neo4j.service.Neo4jHandlerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/neo4j")
@Api(value = "处理neo4j数据")
public class Neo4jDataController {

    private static Logger logger = LoggerFactory.getLogger(Neo4jDataController.class);
    @Autowired
    private Neo4jHandlerService neo4jHandlerService;

    @PostMapping("/findTables/v1")
    @ApiOperation("根据表名称查询关系")
    public String findTables(@RequestBody Map requestParams) {
        String sourceDb = requestParams.get("sourceDb").toString();
        String sourceTableCode = requestParams.get("sourceTableCode").toString();
        List<Map<String, Object>> tables = neo4jHandlerService.findTables(sourceDb, sourceTableCode);
        return JSON.toJSONString(tables);
    }

    @PostMapping("/saveTableRel/v1")
    @ApiOperation("保存表关系")
    public void saveTableRel(@RequestBody Map requestParams) {
        String sourceTableName = requestParams.get("sourceTableName").toString();
        String targetTableName = requestParams.get("targetTableName").toString();
        String sourceDb = requestParams.get("sourceDb").toString();
        String targetDb = requestParams.get("targetDb").toString();
        String sourceTableCode = requestParams.get("sourceTableCode").toString();
        String targetTableCode = requestParams.get("targetTableCode").toString();
        String sourceTableBus = requestParams.get("sourceTableBus").toString();
        String targetTableBus = requestParams.get("targetTableBus").toString();
        String sourceTableCol = requestParams.get("sourceTableCol").toString();
        String targetTableCol = requestParams.get("targetTableCol").toString();


        TableGraph sourceTable = new TableGraph(sourceDb, sourceTableCode, sourceTableName, sourceTableBus);
        TableGraph targetTable = new TableGraph(targetDb, targetTableCode, targetTableName, targetTableBus);

        TableRelationship relationship = new TableRelationship();
        relationship.setStartTable(sourceTable);
        relationship.setEndTable(targetTable);
        relationship.setSource(sourceTableCol);
        relationship.setTarget(targetTableCol);
        neo4jHandlerService.saveTableRelationship(relationship);
    }

    @PostMapping("/saveTableRels/v1")
    @ApiOperation("保存多个表关系")
    public void saveTableRels(@RequestBody Map requestParams) {
        String sourceTableName = requestParams.get("sourceTableName").toString();
        String sourceDb = requestParams.get("sourceDb").toString();
        String sourceTableCode = requestParams.get("sourceTableCode").toString();
        String sourceTableBus = requestParams.get("sourceTableBus").toString();

        List<TableColGraph> list = (List<TableColGraph>) JSONArray.parseArray(JSONArray.toJSONString(requestParams.get("rels")), TableColGraph.class);

        TableGraph sourceTable = new TableGraph(sourceDb, sourceTableCode, sourceTableName, sourceTableBus);

        for (TableColGraph target : list) {
            TableGraph targetTable = new TableGraph(target.getDb(), target.getCode(), target.getName(), target.getBusiness());
            TableRelationship relationship = new TableRelationship();
            relationship.setStartTable(sourceTable);
            relationship.setEndTable(targetTable);
            relationship.setSource(target.getSourceCol());
            relationship.setTarget(target.getCol());
            neo4jHandlerService.saveTableRelationship(relationship);
        }

    }
}
