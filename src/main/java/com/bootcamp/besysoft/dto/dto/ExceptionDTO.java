package com.bootcamp.besysoft.dto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionDTO {

    private Integer statusCode;
    private String message;
    private Map<String,String> details;
}
