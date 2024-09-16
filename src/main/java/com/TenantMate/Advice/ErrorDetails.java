package com.TenantMate.Advice;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorDetails
{
    public ErrorDetails(LocalDateTime time, String message, String details) {
        this.time = time;
        this.message = message;
        this.details = details;
    }

    private LocalDateTime time;
    private String message;
    private String details;
}
