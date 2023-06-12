package com.service.order.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StandardError {

    @JsonFormat(pattern = "dd/MM/YYY HH:mm")
    private LocalDateTime timesTemp;
    private Integer status;
    private String error;
}
