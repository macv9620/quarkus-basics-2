package com.macv.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ElementNotFoundExceptionHandler implements ExceptionMapper<ElementNotFoundCustomException> {

    public static record ExeptionResponseDTO(String message, String detail){}
    @Override
    public Response toResponse(ElementNotFoundCustomException e) {
        ExeptionResponseDTO exeptionResponseDTO = new ExeptionResponseDTO(
                "Upps",
                e.getMessage());
        return Response
                .status(Response.Status.NOT_FOUND)
                .entity(exeptionResponseDTO)
                .build();
    }
}
