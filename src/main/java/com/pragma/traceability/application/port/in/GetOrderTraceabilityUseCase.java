package com.pragma.traceability.application.port.in;

import com.pragma.traceability.domain.model.OrderTraceability;

import java.util.List;

public interface GetOrderTraceabilityUseCase {

    List<OrderTraceability> getByOrderId(Long orderId);

    List<OrderTraceability> getByClientId(Long clientId);

    List<OrderTraceability> getByOrderIdAndClientId(
            Long orderId,
            Long clientId
    );
}