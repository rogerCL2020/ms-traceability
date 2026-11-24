package com.pragma.traceability.application.mapper;

import com.pragma.traceability.application.dto.request.OrderStatusChangedRequest;
import com.pragma.traceability.domain.model.OrderTraceability;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderTraceabilityRequestMapper {

    @Mapping(target = "id", ignore = true)
    OrderTraceability toDomain(OrderStatusChangedRequest request);
}