package com.study;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import java.io.File;

/**
 * neo4j 添加的方法
 *
 * @author qixs
 * @since 2021/07/15
 */
public class EmbeddedNeo4jAdd {

    public static final String STORE_DIR = "java-neo4j-embedded/src/main/resources/graphdb/neo4j";


    public static void main(String[] args) {
        File file = new File(STORE_DIR);
        GraphDatabaseService graphdb = new GraphDatabaseFactory().newEmbeddedDatabase(file);
        System.out.println("databasde load");
        // 开启事务
        Transaction transaction = graphdb.beginTx();

        // 通过节点的方式添加
        Node node = graphdb.createNode();
        node.setProperty("name", "Tom");
        node.setProperty("character","A");
        node.setProperty("gender",1);
        node.setProperty("money",1000);
        node.addLabel(() -> "person");

        // 通过cql的方式添加
        String cql = "create (p:person{name:'Jack',character:'B',gender:1,money:2000})";
        graphdb.execute(cql);
        // 事务成功
        transaction.success();
        // 关闭事务
        transaction.close();
        System.out.println("database close");
        // 关闭数据库
        graphdb.shutdown();
    }
}
