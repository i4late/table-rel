## 安装 neo4j docker
sudo docker pull neo4j:3.4

docker run -it -d -p 7474:7474 -p 7687:7687 neo4j:3.4

重置neo4j用户的密码1q2w3e4r

## noe4j 里执行
CREATE CONSTRAINT ON(n:TABLE)ASSERT n.fullCode IS UNIQUE;
 防止有相同的表实体 fullCode代表 库名.表名 作为唯一值.
 
 
##测试数据
postman 测试,使用 row 模式 json数据格式 的方式


http://127.0.0.1:8080/neo4j/saveTableRel/v1
{
"sourceTableName":"用户表",
"targetTableName":"部门表",
"sourceDb":"test",
 "targetDb":"test",
"sourceTableCode":"user",
 "targetTableCode":"dept",
"sourceTableBus":"税务",
 "targetTableBus":"税务",
"sourceTableCol":"id",
 "targetTableCol":"userid"
}

http://127.0.0.1:8080/neo4j/findTables/v1
{
"sourceTableCode":"user",
"sourceDb":"test"
}

返回  
[{"b.name":"部门表","r.source":"id","a.code":"user","a.db":"test","b.db":"test","b.code":"dept","a.name":"用户表","r.target":"userid"},{"b.name":"部门表","r.source":"id","a.code":"user","a.db":"test","b.db":"test","b.code":"dept","a.name":"用户表","r.target":"userid"}]