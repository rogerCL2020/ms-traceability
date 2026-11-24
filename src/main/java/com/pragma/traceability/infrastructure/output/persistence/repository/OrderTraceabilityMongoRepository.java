package com.pragma.traceability.infrastructure.output.persistence.repository;

import com.pragma.traceability.infrastructure.output.persistence.document.OrderTraceabilityDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderTraceabilityMongoRepository
        extends MongoRepository<OrderTraceabilityDocument, String> {

    List<OrderTraceabilityDocument> findByOrderIdOrderByDateAsc(Long orderId);

    List<OrderTraceabilityDocument> findByClientIdOrderByDateDesc(Long clientId);

    List<OrderTraceabilityDocument> findByOrderIdAndClientIdOrderByDateAsc(
            Long orderId,
            Long clientId
    );
}