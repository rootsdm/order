package com.service.order.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldMessage {
    private String fieldName; // campo do erro
    private String message; // mensagem erro

}
