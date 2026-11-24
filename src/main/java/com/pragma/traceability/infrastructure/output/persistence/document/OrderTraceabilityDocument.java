package com.pragma.traceability.infrastructure.output.persistence.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "order_traceability")
public class OrderTraceabilityDocument {

    @Id
    private String id;

    @Field("idPedido")
    private Long orderId;

    @Field("idCliente")
    private Long clientId;

    @Field("correoCliente")
    private String clientEmail;

    @Field("fecha")
    private LocalDateTime date;

    @Field("estadoAnterior")
    private String previousStatus;

    @Field("estadoNuevo")
    private String newStatus;

    @Field("idEmpleado")
    private Long employeeId;

    @Field("correoEmpleado")
    private String employeeEmail;
}