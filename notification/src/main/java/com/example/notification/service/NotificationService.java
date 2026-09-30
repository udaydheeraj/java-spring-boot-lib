package com.example.notification.service;


import com.example.notification.dto.request.CreateNotificationRequest;
import com.example.notification.dto.response.NotificationResponse;
import org.springframework.data.domain.Page;

public interface NotificationService {

    NotificationResponse createNotification(
            CreateNotificationRequest request
    );

    Page<NotificationResponse> getUserNotifications(
            Long userId,
            int page,
            int size
    );

    Page<NotificationResponse> getUnreadNotifications(
            Long userId,
            int page,
            int size
    );

    Long getUnreadNotificationCount(
            Long userId
    );

    NotificationResponse markAsRead(
            Long notificationId,
            Long userId
    );

    void markAllRead(
            Long userId
    );

    void deleteNotification(
            Long notificationId,
            Long userId
    );
}
