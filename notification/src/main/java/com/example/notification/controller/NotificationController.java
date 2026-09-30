package com.example.notification.controller;

import com.example.notification.dto.request.CreateNotificationRequest;
import com.example.notification.dto.response.NotificationResponse;
import com.example.notification.service.NotificationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class NotificationController {

    public final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    // create notification

    @PostMapping("/notifications")
    public ResponseEntity<NotificationResponse> createNotification(
          @Valid @RequestBody CreateNotificationRequest notificationRequest
)
    {
        NotificationResponse notificationResponse =
                 notificationService.createNotification(notificationRequest);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(notificationResponse);
    }

    //Get user's notifications

    @GetMapping("/users/{userId}/notifications")
    public ResponseEntity<Page<NotificationResponse>> getUserNotifications(
                        @PathVariable Long userId,

                        @RequestParam(defaultValue = "0")
                        int page,

                       @RequestParam(defaultValue = "10")
                       int size
    )
    {
        Page<NotificationResponse> responses = notificationService.getUserNotifications(userId, page, size);

        return ResponseEntity.ok(responses);
    }

    @GetMapping("/users/{userId}/notifications/unread")
    public ResponseEntity<Page<NotificationResponse>> getUserNotificationsUnread(
           @PathVariable Long userId,


           @RequestParam(defaultValue = "0")
           int page,

           @RequestParam(defaultValue = "10")
           int size
    )
    {

        Page<NotificationResponse> responses = notificationService.getUnreadNotifications(userId,page,size);

        return ResponseEntity.ok(responses);
    }


    // 4. get unread notifications count
    @GetMapping("/users/{userId}/notifications/unread/count")
    ResponseEntity<Long> getUnreadNotificationCount(
          @PathVariable  Long userId
    )
    {
        long count = notificationService.getUnreadNotificationCount(userId);

        return ResponseEntity.ok(count);
    }


    // 5. mark notifications as read

    @PatchMapping("/notifications/{notificationId}/read")
    public ResponseEntity<NotificationResponse> markAsRead(
           @PathVariable Long notificationId,
            @RequestParam Long userId
    )
    {

        NotificationResponse response = notificationService.markAsRead(notificationId,userId);

        return ResponseEntity.ok(response);
    }

    // 6. Mark all notifications as read
    @PatchMapping("/users/{userId}/notifications/read-all")
    public ResponseEntity<Void> markAllAsRead(
            @PathVariable Long userId
    ) {

        notificationService.markAllRead(userId);

        return ResponseEntity.noContent().build();
    }


    // 7. Delete notification
    @DeleteMapping("/notifications/{notificationId}")
    public ResponseEntity<Void> deleteNotification(
            @PathVariable Long notificationId,

            @RequestParam Long userId
    ) {

        notificationService.deleteNotification(
                notificationId,
                userId
        );

        return ResponseEntity.noContent().build();
    }





}
