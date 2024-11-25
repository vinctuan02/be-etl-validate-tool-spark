package com.example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="table_pair")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "pairId")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TablePair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "pair_id", nullable = false)
    private Integer pairId;

    @ManyToOne
    @JoinColumn(name = "report_id", nullable = false)
    @JsonBackReference
    private Report report;

    @Column(name= "source_table_name", nullable = false)
    private String sourceTableName;

    @Column(name= "sink_table_name", nullable = false)
    private String sinkTableName;

    @Column(name = "source_database_name")
    private String sourceDatabaseName;

    @Column(name = "sink_database_name")
    private String sinkDatabaseName;

    @ManyToOne
    @JoinColumn(name = "source_jdbc_id", nullable = false)
    @JsonBackReference
    private JDBCConnection sourceJDBCConnection;

    // Many TablePairs can refer to one JdbcConnection as their sink
    @ManyToOne
    @JoinColumn(name = "sink_jdbc_id", nullable = false)
    @JsonBackReference
    private JDBCConnection sinkJDBCConnection;
}