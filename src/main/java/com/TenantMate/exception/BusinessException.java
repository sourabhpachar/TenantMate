package com.TenantMate.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)

public class BusinessException extends RuntimeException {
    public BusinessException(String businessExceptionThrown) {
        super(businessExceptionThrown);
    }
}
