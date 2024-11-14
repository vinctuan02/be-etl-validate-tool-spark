package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@Table(name="table_pair")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "pairId")
public class TablePair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "pair_id", nullable = false)
    private Integer pairId;

//    @Column(name= "report_id", nullable = false)
//    private Integer reportId;

    @Column(name= "source_table_name", nullable = false)
    private String sourceTableName;

    @Column(name= "sink_table_name", nullable = false)
    private String sinkTableNames;

    @Column(name = "source_database_name")
    private String sourceDatabaseName;

    @Column(name = "sink_database_name")
    private String sinkDatabaseName;

    @ManyToOne
    @JoinColumn(name = "source_jdbc_id", nullable = false)
    private JDBCConnection sourceJDBCConnection;

    // Many TablePairs can refer to one JdbcConnection as their sink
    @ManyToOne
    @JoinColumn(name = "sink_jdbc_id", nullable = false)
    private JDBCConnection sinkJDBCConnection;

    @ManyToOne
    @JoinColumn(name = "report_id", nullable = false)
    private Report report;

    public Integer getPairId() {
        return pairId;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }
//
//    public Integer getReportId() {
//        return reportId;
//    }
//
//    public void setReportId(Integer reportId) {
//        this.reportId = reportId;
//    }

    public String getSourceTableName() {
        return sourceTableName;
    }

    public void setSourceTableName(String sourceTableName) {
        this.sourceTableName = sourceTableName;
    }

    public String getSinkTableNames() {
        return sinkTableNames;
    }

    public void setSinkTableNames(String sinkTableNames) {
        this.sinkTableNames = sinkTableNames;
    }

    public String getSourceDatabaseName() {
        return sourceDatabaseName;
    }

    public void setSourceDatabaseName(String sourceDatabaseName) {
        this.sourceDatabaseName = sourceDatabaseName;
    }

    public String getSinkDatabaseName() {
        return sinkDatabaseName;
    }

    public void setSinkDatabaseName(String sinkDatabaseName) {
        this.sinkDatabaseName = sinkDatabaseName;
    }

    public JDBCConnection getSourceJDBCConnection() {
        return sourceJDBCConnection;
    }

    public void setSourceJDBCConnection(JDBCConnection sourceJDBCConnection) {
        this.sourceJDBCConnection = sourceJDBCConnection;
    }

    public JDBCConnection getSinkJDBCConnection() {
        return sinkJDBCConnection;
    }

    public void setSinkJDBCConnection(JDBCConnection sinkJDBCConnection) {
        this.sinkJDBCConnection = sinkJDBCConnection;
    }
}