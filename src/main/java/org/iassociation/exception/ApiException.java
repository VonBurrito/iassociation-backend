package org.iassociation.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Hamza Amentag
 * @since 6/3/2022
 */
public class ApiException {

    private final String message;
    private final HttpStatus httpStatus;

    public ApiException(String message,
                        HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
