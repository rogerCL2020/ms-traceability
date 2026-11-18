
db = db.getSiblingDB('pragma_traceability');

// Crear colección con validación de estructura
db.createCollection('order_traceability', {
    validator: {
        $jsonSchema: {
            bsonType: "object",
            required: [
                "idPedido",
                "idCliente",
                "correoCliente",
                "fecha",
                "estadoNuevo"
            ],
            properties: {
                _id: {
                    bsonType: "objectId",
                    description: "Identificador único del registro"
                },
                idPedido: {
                    bsonType: "long",
                    description: "Identificador del pedido"
                },
                idCliente: {
                    bsonType: "long",
                    description: "Identificador del cliente"
                },
                correoCliente: {
                    bsonType: "string",
                    description: "Correo electrónico del cliente"
                },
                fecha: {
                    bsonType: "date",
                    description: "Fecha y hora del cambio de estado"
                },
                estadoAnterior: {
                    bsonType: ["string", "null"],
                    description: "Estado anterior del pedido"
                },
                estadoNuevo: {
                    bsonType: "string",
                    description: "Nuevo estado del pedido"
                },
                idEmpleado: {
                    bsonType: ["long", "null"],
                    description: "Identificador del empleado responsable"
                },
                correoEmpleado: {
                    bsonType: ["string", "null"],
                    description: "Correo electrónico del empleado"
                }
            }
        }
    },
    validationLevel: "strict",
    validationAction: "error"
});

// Índice para consultar la trazabilidad por pedido
db.order_traceability.createIndex(
    { idPedido: 1 },
    { name: "idx_id_pedido" }
);

// Índice para consultar la trazabilidad del cliente por fecha
db.order_traceability.createIndex(
    { idCliente: 1, fecha: -1 },
    { name: "idx_id_cliente_fecha" }
);

print("Base de datos pragma_traceability inicializada.");
print("Colección order_traceability creada con esquema de validación.");
print("Índices creados correctamente.");
