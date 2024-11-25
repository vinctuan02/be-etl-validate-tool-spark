package com.example.mapper;

import com.example.dto.request.ReportCreationRequest;
import com.example.dto.response.ReportCreationResponse;
import com.example.entity.Report;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface ReportMapper {
    Report toReport(ReportCreationRequest request);
    Report toReport(ReportCreationResponse response);
    ReportCreationResponse toReportCreationResponse (Report report);
}
