
package com.pragma.traceability.infrastructure.input.rest.controller;

import com.pragma.traceability.application.dto.request.OrderStatusChangedRequest;
import com.pragma.traceability.application.dto.response.OrderTraceabilityResponse;
import com.pragma.traceability.application.mapper.OrderTraceabilityRequestMapper;
import com.pragma.traceability.application.mapper.OrderTraceabilityResponseMapper;
import com.pragma.traceability.application.port.in.GetOrderTraceabilityUseCase;
import com.pragma.traceability.application.port.in.SaveOrderTraceabilityUseCase;
import com.pragma.traceability.domain.model.OrderTraceability;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/traceability")
@RequiredArgsConstructor
public class OrderTraceabilityController {

    private final SaveOrderTraceabilityUseCase saveOrderTraceabilityUseCase;
    private final GetOrderTraceabilityUseCase getOrderTraceabilityUseCase;
    private final OrderTraceabilityRequestMapper orderTraceabilityRequestMapper;
    private final OrderTraceabilityResponseMapper orderTraceabilityResponseMapper;

    @PostMapping("/events")
    public ResponseEntity<Void> save(
            @RequestBody OrderStatusChangedRequest request
    ) {
        OrderTraceability orderTraceability =
                orderTraceabilityRequestMapper.toDomain(request);

        saveOrderTraceabilityUseCase.save(orderTraceability);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/orders/{orderId}")
    public ResponseEntity<List<OrderTraceabilityResponse>> getByOrderId(
            @PathVariable Long orderId,
            @RequestParam Long clientId
    ) {

        List<OrderTraceability> traceability =
                getOrderTraceabilityUseCase.getByOrderIdAndClientId(
                        orderId,
                        clientId
                );

        return ResponseEntity.ok(
                orderTraceabilityResponseMapper.toResponseList(traceability)
        );
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderTraceabilityResponse>> getByClient(
            @RequestParam Long clientId
    ) {

        List<OrderTraceability> traceability =
                getOrderTraceabilityUseCase.getByClientId(clientId);

        return ResponseEntity.ok(
                orderTraceabilityResponseMapper.toResponseList(traceability)
        );
    }
}
