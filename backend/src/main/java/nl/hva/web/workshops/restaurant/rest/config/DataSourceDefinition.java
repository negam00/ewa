package nl.hva.web.workshops.restaurant.rest.config;

import javax.ejb.Stateless;

@javax.annotation.sql.DataSourceDefinition(
        name = "java:comp/env/jdbc/aquadis",
        className = "com.mysql.cj.jdbc.MysqlXADataSource",
        url = "jdbc:mysql://localhost:3306/aquadis?createDatabaseIfNotExist=true&serverTimezone=CET",
        user = "root",
        password = "Ww231ww231!")
@Stateless

public class DataSourceDefinition {
}
