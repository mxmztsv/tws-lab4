package ru.mxmztsv.app.soap.exception.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientErrorDto {
    private String message;
    private int status;
}
