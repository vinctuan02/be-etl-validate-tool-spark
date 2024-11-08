package com.example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name="table_pair")
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

    @Column(name= "source_jdbc_id", nullable = false)
    private String sourceJDBCId;

    @Column(name= "sink_jdbc_id", nullable = false)
    private String sinkJDBCId;

    @ManyToOne
    @JoinColumn(name = "report_id", nullable = false)
    @JsonBackReference
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

    public String getSourceJDBCId() {
        return sourceJDBCId;
    }

    public void setSourceJDBCId(String sourceJDBCId) {
        this.sourceJDBCId = sourceJDBCId;
    }

    public String getSinkJDBCId() {
        return sinkJDBCId;
    }

    public void setSinkJDBCId(String sinkJDBCId) {
        this.sinkJDBCId = sinkJDBCId;
    }
}