package com.example.entity;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "report")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "reportId")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    private Integer reportId;

    @Column(name = "report_name", nullable = false)
    private String reportName;

    @Column(name = "status",nullable = false)
    private String status;

    @Column(columnDefinition = "TEXT")
    private String note;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @OneToMany(mappedBy = "report", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<TablePair> tablePairs;

    public List<TablePair> getTablePairs() {
        return tablePairs;
    }

    public void setTablePairs(List<TablePair> tablePairs) {
        this.tablePairs = tablePairs;
    }

    // Phương thức để thêm một TablePair vào Report
    public void addTablePair(TablePair tablePair) {
        tablePairs.add(tablePair);
        tablePair.setReport(this); // Gán Report hiện tại cho TablePair
    }

    // Phương thức để xóa một TablePair khỏi Report
    public void removeTablePair(TablePair tablePair) {
        tablePairs.remove(tablePair);
        tablePair.setReport(null); // Xóa tham chiếu tới Report khỏi TablePair
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public Integer getReportId() {
        return reportId;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}

