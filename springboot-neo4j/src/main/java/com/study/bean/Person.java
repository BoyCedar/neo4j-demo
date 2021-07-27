package com.study.bean;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@Data
@NodeEntity
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @Property("cid")
    private int pid;

    private String name;

    private String character;

    private double money;

    private int gender;

    private int age;

    private String description;
}
