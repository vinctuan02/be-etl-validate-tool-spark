package com.example.mapper;

import com.example.dto.request.ReportCreationRequest;
import com.example.dto.response.ReportCreationResponse;
import com.example.entity.Report;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "Spring", uses = {TablePairMapper.class})
public interface ReportMapper {
    Report toReport(ReportCreationRequest request);
    Report toReport(ReportCreationResponse response);

    @Mapping(source = "tablePairs", target = "tablePairCreationResponses")
    ReportCreationResponse toReportCreationResponse (Report report);
}
