package com.example.notification.dto.response;

import com.example.notification.entity.NotificationPriority;
import com.example.notification.entity.NotificationStatus;
import com.example.notification.entity.NotificationType;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record NotificationResponse (

    @NotNull
     Long id,

    @NotNull
     Long userId,

    @NotNull
     NotificationType type,

    @NotNull
     String title,

    @NotNull
     String message,

    @NotNull
     NotificationPriority priority,

    @NotNull
     NotificationStatus status,

    @NotNull
     LocalDateTime createdAt,


     LocalDateTime readAt,


     LocalDateTime expiresAt
){

}
