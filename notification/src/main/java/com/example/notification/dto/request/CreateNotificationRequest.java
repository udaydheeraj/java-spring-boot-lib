package com.example.notification.dto.request;


import com.example.notification.entity.NotificationPriority;
import com.example.notification.entity.NotificationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateNotificationRequest (

    @NotNull(message = "User ID is required")
     Long userId,

    @NotNull(message = "Notification type is required")
     NotificationType type,

    @NotBlank(message = "Title is required")
    @Size(max = 150, message = "Title must not exceed 150 characters")
     String title,

    @NotBlank(message = "Message is required")
    @Size(max = 2000, message = "Message must not exceed 2000 characters")
     String message,

    @NotNull(message = "Priority is required")
     NotificationPriority priority
){

        }
