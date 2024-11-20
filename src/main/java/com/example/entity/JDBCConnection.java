package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="jdbc_connection")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "jdbcId")
public class JDBCConnection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jdbc_id", nullable = false)
    private Integer jdbcId;

    @Column(name = "jdbc_name", nullable = false)
    private String jdbcName;

    @Column(name = "jdbc_url", nullable = false)
    private String jdbcUrl;

    @Column(name = "jdbc_user", nullable = false)
    private String jdbcUser;

    @Column(name = "jdbc_password", nullable = false)
    private String jdbcPassword;

    @Column(name = "database_type", nullable = false)
     private String databaseType;

//     Quan hệ với TablePair
    @OneToMany(mappedBy = "sourceJDBCConnection", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<TablePair> sourceTablePairs;

    @OneToMany(mappedBy = "sinkJDBCConnection", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<TablePair> sinkTablePairs;

    public List<TablePair> getSourceTablePairs() {
        return sourceTablePairs;
    }

    public void setSourceTablePairs(List<TablePair> sourceTablePairs) {
        this.sourceTablePairs = sourceTablePairs;
    }

    public List<TablePair> getSinkTablePairs() {
        return sinkTablePairs;
    }

    public void setSinkTablePairs(List<TablePair> sinkTablePairs) {
        this.sinkTablePairs = sinkTablePairs;
    }


    public Integer getJdbcId() {
        return jdbcId;
    }

    public String getJdbcName() {
        return jdbcName;
    }

    public void setJdbcName(String jdbcName) {
        this.jdbcName = jdbcName;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getJdbcUser() {
        return jdbcUser;
    }

    public void setJdbcUser(String jdbcUser) {
        this.jdbcUser = jdbcUser;
    }

    public String getJdbcPassword() {
        return jdbcPassword;
    }

    public void setJdbcPassword(String jdbcPassword) {
        this.jdbcPassword = jdbcPassword;
    }

    public String getDatabaseType() {
        return databaseType;
    }

    public void setDatabaseType(String databaseType) {
        this.databaseType = databaseType;
    }

}
