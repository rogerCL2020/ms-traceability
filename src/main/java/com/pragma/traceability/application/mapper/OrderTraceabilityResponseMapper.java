package com.pragma.traceability.application.mapper;

import com.pragma.traceability.application.dto.response.OrderTraceabilityResponse;
import com.pragma.traceability.domain.model.OrderTraceability;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderTraceabilityResponseMapper {

    OrderTraceabilityResponse toResponse(OrderTraceability orderTraceability);

    List<OrderTraceabilityResponse> toResponseList(
            List<OrderTraceability> orderTraceabilityList
    );
}