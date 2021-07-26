package com.study;

import org.neo4j.driver.*;

import static org.neo4j.driver.Values.parameters;

/**
 * 最短路径的查询
 *
 * @author qixs
 * @since 2021/07/20
 */
public class ServerNeo4jShortPathQuery {

    public static void main(String[] args) {
        Driver driver = GraphDatabase.driver("bolt://81.70.202.213:7687", AuthTokens.basic("neo4j","123456"));
        Session session = driver.session();
        String cql = "match p = shortestpath((n1:Person{name:$startName}) - [*] - (n2:Person{name:$endName})) return p";
        String cqlHaveScope = "match p = shortestpath((n1:Person{name:$startName}) - [*1..4] - (n2:Person{name:$endName})) return p";
        String cqlMore = "match p = (n1:Person{name:$startName}) - [*] - (n2:Person{name:$endName}) return p";
        Result result = session.run(cqlMore,parameters("startName","王启年","endName","九品射手燕小乙"));
        while (result.hasNext()) {
            Record record = result.next();
            System.out.println(record);
        }
        session.close();
        driver.close();
    }
}
