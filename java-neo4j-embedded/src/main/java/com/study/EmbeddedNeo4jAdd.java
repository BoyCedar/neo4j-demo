package com.study;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.kernel.impl.factory.GraphDatabaseFacade;

import java.io.File;

/**
 * neo4j 添加的方法
 *
 * @author qixs
 * @since 2021/07/15
 */
public class EmbeddedNeo4jAdd {

    public static final String STORE_DIR = "/graphdb/neo4j";


    public static void main(String[] args) {
        File file = new File(STORE_DIR);
        GraphDatabaseService graphdb = new GraphDatabaseFactory().newEmbeddedDatabase(file);

    }
}
