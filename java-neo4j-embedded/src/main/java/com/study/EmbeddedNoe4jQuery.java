package com.study;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * neo4j 的查询方法
 *
 * @author qixs
 * @since 2021/07/15
 */
public class EmbeddedNoe4jQuery {

    public static final String STORE_DIR = "java-neo4j-embedded/src/main/resources/graphdb/neo4j";

    public static void main(String[] args) {
        File file = new File(STORE_DIR);
        GraphDatabaseService graphdb  = new GraphDatabaseFactory().newEmbeddedDatabase(file);
        System.out.println("databasde load");
        Transaction tx = graphdb.beginTx();
        String cql = "match (p:person)  where p.money > $money return p";
        Map<String,Object> parameter = new HashMap<>(16);
        parameter.put("money",900);
        Result result = graphdb.execute(cql,parameter);
        while (result.hasNext()) {
            Map<String, Object> row = result.next();
            for (String column : result.columns()) {
                Node node = (Node)row.get(column);
                System.out.printf("%s = %s:%s%n",column,node.getProperty("name"),node.getProperty("money"));
            }
        }
        // 事务成功
        tx.success();
        // 关闭事务
        tx.close();
        System.out.println("database close");
        // 关闭数据库
        graphdb.shutdown();

    }
}
