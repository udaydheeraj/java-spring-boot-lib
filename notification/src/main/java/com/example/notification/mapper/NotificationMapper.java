package com.example.notification.mapper;

import com.example.notification.dto.request.CreateNotificationRequest;
import com.example.notification.dto.response.NotificationResponse;
import com.example.notification.entity.Notification;
import com.example.notification.entity.User;

public final class NotificationMapper {
    public NotificationMapper() {
    }

    public static Notification toEntity(
            CreateNotificationRequest request,
            User user
    )
    {
        Notification notification = new Notification();

        notification.setUser(user);
        notification.setType(request.type());
        notification.setTitle(request.title());
        notification.setPriority(request.priority());
        notification.setMessage(request.message());



        return notification;
    }

    public static NotificationResponse toResponse(
            Notification notification
    )
    {
        return new NotificationResponse(
                notification.getId(),
                notification.getUser().getId(),
                notification.getType(),
                notification.getTitle(),
                notification.getMessage(),
                notification.getPriority(),
                notification.getStatus(),
                notification.getCreatedAt(),
                notification.getReadAt(),
                notification.getExpireAt()
        );
    }

}
