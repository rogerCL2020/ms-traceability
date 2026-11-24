package com.pragma.traceability.infrastructure.output.persistence.adapter;

import com.pragma.traceability.application.port.out.OrderTraceabilityRepositoryPort;
import com.pragma.traceability.domain.model.OrderTraceability;
import com.pragma.traceability.infrastructure.output.persistence.mapper.OrderTraceabilityDocumentMapper;
import com.pragma.traceability.infrastructure.output.persistence.repository.OrderTraceabilityMongoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderTraceabilityPersistenceAdapter implements OrderTraceabilityRepositoryPort {

    private final OrderTraceabilityMongoRepository orderTraceabilityMongoRepository;
    private final OrderTraceabilityDocumentMapper orderTraceabilityDocumentMapper;

    @Override
    public OrderTraceability save(OrderTraceability orderTraceability) {
        var document = orderTraceabilityDocumentMapper.toDocument(orderTraceability);

        var savedDocument = orderTraceabilityMongoRepository.save(document);

        return orderTraceabilityDocumentMapper.toDomain(savedDocument);
    }

    @Override
    public List<OrderTraceability> findByOrderId(Long orderId) {
        return orderTraceabilityMongoRepository
                .findByOrderIdOrderByDateAsc(orderId)
                .stream()
                .map(orderTraceabilityDocumentMapper::toDomain)
                .toList();
    }

    @Override
    public List<OrderTraceability> findByClientId(Long clientId) {
        return orderTraceabilityMongoRepository
                .findByClientIdOrderByDateDesc(clientId)
                .stream()
                .map(orderTraceabilityDocumentMapper::toDomain)
                .toList();
    }

    @Override
    public List<OrderTraceability> findByOrderIdAndClientId(
            Long orderId,
            Long clientId
    ) {
        return orderTraceabilityMongoRepository
                .findByOrderIdAndClientIdOrderByDateAsc(orderId, clientId)
                .stream()
                .map(orderTraceabilityDocumentMapper::toDomain)
                .toList();
    }
}