package com.pragma.traceability.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class OrderTraceability {

    private String id;
    private Long orderId;
    private Long clientId;
    private String clientEmail;
    private LocalDateTime date;
    private String previousStatus;
    private String newStatus;
    private Long employeeId;
    private String employeeEmail;
}