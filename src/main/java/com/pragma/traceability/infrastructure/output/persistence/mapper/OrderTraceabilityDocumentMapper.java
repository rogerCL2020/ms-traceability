package com.pragma.traceability.infrastructure.output.persistence.mapper;

import com.pragma.traceability.domain.model.OrderTraceability;
import com.pragma.traceability.infrastructure.output.persistence.document.OrderTraceabilityDocument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderTraceabilityDocumentMapper {

    OrderTraceabilityDocument toDocument(OrderTraceability orderTraceability);

    OrderTraceability toDomain(OrderTraceabilityDocument document);
}