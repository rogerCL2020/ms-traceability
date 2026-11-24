package com.pragma.traceability.application.port.out;

import com.pragma.traceability.domain.model.OrderTraceability;

import java.util.List;

public interface OrderTraceabilityRepositoryPort {

    OrderTraceability save(OrderTraceability orderTraceability);

    List<OrderTraceability> findByOrderId(Long orderId);

    List<OrderTraceability> findByClientId(Long clientId);

    List<OrderTraceability> findByOrderIdAndClientId(
            Long orderId,
            Long clientId
    );
}