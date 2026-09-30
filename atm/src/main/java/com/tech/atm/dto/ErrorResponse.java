package com.tech.atm.dto;

import java.time.LocalDateTime;

public record ErrorResponse(
        LocalDateTime timestamp, // Fixed typo from 'timesStamp' to 'timestamp'
        int status,
        String error,
        String message,
        String path
) {}
