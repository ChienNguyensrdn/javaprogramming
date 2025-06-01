# JPA + ORM 
## JPA Entity Manager
1. The entity manager implements the API and encapsulates all of them within a single interface.
- Manages entity lifecycle: Persist, find, merge, remove
- Controls persistence context: Cache, flush, detach
- Executes queries: JPQL, Criteria API
- Handles transactions: Begin, commit, rollback
- Provides access to entity metadata

2. Key Operations of the Entity Manager
- Persisting Entities: em.persist(entity) makes a transient entity instance persistent
- Finding Entities: em.find(entityClass,primaryKey) retrieves an entity by its primary  key.
- Merging Entities: em.merge(entity) merges a detached entity instance into the current persistence context.
- Removing Entities: em.remove(entity) removes a persistent entity instance.
- Querying Data: em.createQuery(jpqlString  creates a JPQL query to retrieve entities based on specified criteria.

## Create Project maven 
- win os 
    ```bash
    control + shift + p 
    ```
- mac os
    ```bash
    command + shift + p
    ```
- pormt : Create Project Java -> maven -> None  Architect -> rename package uth.edu -> Project -> chose folder project

- Open file pom.xml : Install package, infomation project 
    ```xml
    <dependencies>
        <dependency>
            <groupId>org.eclipse.persistence</groupId>
            <artifactId>javax.persistence</artifactId>
            <version>2.2.0</version>
        </dependency>
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-entitymanager</artifactId>
            <version>5.6.9.Final</version>
        </dependency>
        <dependency>
            <groupId>com.microsoft.sqlserver</groupId>
            <artifactId>mssql-jdbc</artifactId>
            <version>11.2.3.jre17</version>
        </dependency>
    </dependencies>
    ```
- Create persistence.xml in META-INF folder:
    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <persistence version="2.2"
                 xmlns="http://xmlns.jcp.org/xml/ns/persistence"
                 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                 xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence
                                     http://xmlns.jcp.org/xml/ns/persistence_2_2.xsd">
        <persistence-unit name="JPAs"
                          transaction-type="RESOURCE_LOCAL">
            <properties>
                <property name="javax.persistence.jdbc.driver"
                          value="com.microsoft.sqlserver.jdbc.SQLServerDriver"/>
                <property name="javax.persistence.jdbc.url"
                          value="jdbc:sqlserver://localhost:1433;databaseName=tutorial;encrypt=true;
                                 trustServerCertificate=true;"/>
                <property name="javax.persistence.jdbc.user" value="sa"/>
                <property name="javax.persistence.jdbc.password"
                          value="Aesx589999"/>
                <property name="hibernate.dialect"
                          value="org.hibernate.dialect.SQLServerDialect"/>
                <property name="hibernate.show_sql" value="true"/>
                <property name="hibernate.hbm2ddl.auto" value="update"/>
            </properties>
        </persistence-unit>
    </persistence>
    ```
- Add com.fe.pojo Package in src/main/java
- Create class Student.java in Package pojo
    ```java
    package uth.edu.pojo;
    public class Student {
        private String name;
        private int age;
        private String studentId;
        public Student() {
        }
        public Student(String name, int age, String studentId) {
            this.name = name;
            this.age = age;
            this.studentId = studentId;
        }
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public int getAge() {
            return age;
        }
    
        public void setAge(int age) {
            this.age = age;
        }
    
        public String getStudentId() {
            return studentId;
        }
    
        public void setStudentId(String studentId) {
            this.studentId = studentId;
        }
    }
    ```
- Add com.fe.dao Package in src/main/java
- Create class StudentDAO in Package dao
    ```java
    ```
    
    
    