package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="jdbc_connection")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "jdbcId")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
}
