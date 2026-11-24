package com.pragma.traceability.application.service;

import com.pragma.traceability.application.port.in.GetOrderTraceabilityUseCase;
import com.pragma.traceability.application.port.in.SaveOrderTraceabilityUseCase;
import com.pragma.traceability.application.port.out.OrderTraceabilityRepositoryPort;
import com.pragma.traceability.domain.model.OrderTraceability;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderTraceabilityService implements
        SaveOrderTraceabilityUseCase,
        GetOrderTraceabilityUseCase {

    private final OrderTraceabilityRepositoryPort orderTraceabilityRepositoryPort;

    @Override
    public OrderTraceability save(OrderTraceability orderTraceability) {
        return orderTraceabilityRepositoryPort.save(orderTraceability);
    }

    @Override
    public List<OrderTraceability> getByOrderId(Long orderId) {
        return orderTraceabilityRepositoryPort.findByOrderId(orderId);
    }

    @Override
    public List<OrderTraceability> getByClientId(Long clientId) {
        return orderTraceabilityRepositoryPort.findByClientId(clientId);
    }

    @Override
    public List<OrderTraceability> getByOrderIdAndClientId(
            Long orderId,
            Long clientId
    ) {
        return orderTraceabilityRepositoryPort
                .findByOrderIdAndClientId(orderId, clientId);
    }
}