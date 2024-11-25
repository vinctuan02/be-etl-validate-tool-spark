package com.example.mapper;

import com.example.dto.request.TablePairCreationRequest;
import com.example.dto.response.TablePairCreationResponse;
import com.example.entity.TablePair;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TablePairMapper {
    TablePair toTablePair(TablePairCreationRequest request);
    TablePairCreationResponse toTablePairCreationResponse(TablePair tablePair);
}
