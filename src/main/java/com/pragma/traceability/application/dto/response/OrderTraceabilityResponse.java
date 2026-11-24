package com.pragma.traceability.application.dto.response;

import java.time.LocalDateTime;

public record OrderTraceabilityResponse(

        String id,
        Long orderId,
        Long clientId,
        String clientEmail,
        LocalDateTime date,
        String previousStatus,
        String newStatus,
        Long employeeId,
        String employeeEmail

) {
}