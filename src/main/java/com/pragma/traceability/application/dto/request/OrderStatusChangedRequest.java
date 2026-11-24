package com.pragma.traceability.application.dto.request;

import java.time.LocalDateTime;

public record OrderStatusChangedRequest(

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