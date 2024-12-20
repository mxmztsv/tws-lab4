package ru.mxmztsv.app.soap.exception;

import jakarta.xml.ws.WebFault;
import lombok.Getter;
import ru.mxmztsv.app.soap.exception.model.ClientErrorDto;

@Getter
@WebFault(faultBean = "com.wishmaster.ifmo.ws.jaxws.errors.PersonServiceFault")
public class ClientServiceException extends Exception {
    private static final long serialVersionUID = -6647544772732631047L;
    private ClientErrorDto errorDto;

    public ClientServiceException(String message) {
        super(message);
        errorDto = ClientErrorDto.builder().message(message).status(500).build();
    }

    public ClientServiceException(String message, int statusCode) {
        super(message);
        errorDto = ClientErrorDto.builder().message(message).status(statusCode).build();
    }
}
