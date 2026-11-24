package com.pragma.traceability.application.port.in;

import com.pragma.traceability.domain.model.OrderTraceability;

public interface SaveOrderTraceabilityUseCase {

    OrderTraceability save(OrderTraceability orderTraceability);
}