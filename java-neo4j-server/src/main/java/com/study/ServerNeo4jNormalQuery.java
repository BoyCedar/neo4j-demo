package com.study;

import org.neo4j.driver.*;

import static org.neo4j.driver.Values.parameters;


/**
 * 服务器的 neo4j 的普通查询
 *
 * @author qixs
 * @since 2021/07/20
 */
public class ServerNeo4jNormalQuery {

    public static void main(String[] args) {
        Driver driver = GraphDatabase.driver("neo4j://81.70.202.213:7687", AuthTokens.basic("neo4j","123456"));
        Session session = driver.session();
        String cql = "match(p:Person) where p.money > $money return p.money as money, p.name as name order by p.money";
        Result result = session.run(cql, parameters("money", 1000));
        while (result.hasNext()) {
            Record record = result.next();
            System.out.println(record.get("name").asString() + " " + record.get("money").asDouble());
        }
        session.close();
        driver.close();

    }
}
