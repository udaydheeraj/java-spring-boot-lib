package com.example.notification.service;

import com.example.notification.Repository.NotificationRepository;
import com.example.notification.Repository.UserRepository;
import com.example.notification.dto.request.CreateNotificationRequest;
import com.example.notification.dto.response.NotificationResponse;
import com.example.notification.entity.Notification;
import com.example.notification.entity.NotificationStatus;
import com.example.notification.entity.User;
import com.example.notification.exception.UserNotFoundException;
import com.example.notification.mapper.NotificationMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class NotificationServiceImpl implements NotificationService{

    private final NotificationRepository notificationRepository;

    private final UserRepository userRepository;

    NotificationServiceImpl(NotificationRepository notificationRepository,
                            UserRepository userRepository )
    {
        this.notificationRepository = notificationRepository;
        this.userRepository = userRepository;
    }


    private void validateUser(Long userId)
    {
        if (!userRepository.existsById(userId)) {

            throw new RuntimeException(
                    "User not found with id: " + userId
            );
        }
    }

    @Override
    @Transactional
    public NotificationResponse createNotification(CreateNotificationRequest request) {

        User user = userRepository.findById(request.userId())
                .orElseThrow( () ->
                        new UserNotFoundException("user not found exception at runtime: id : " + request.userId()
                        )
                );

        Notification notification = NotificationMapper.toEntity(request,user);

        notification.setStatus(NotificationStatus.UNREAD);
        notification.setCreatedAt(LocalDateTime.now());
        notification.setReadAt(null);

        Notification savedNotification = notificationRepository.save(notification);


        return NotificationMapper.toResponse(savedNotification);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<NotificationResponse> getUserNotifications(Long userId, int page, int size) {

        validateUser(userId);
        Pageable pageable = createPageable(page,size);
        Page<Notification> notifications = notificationRepository.findByUser_Id(userId,pageable);

        return notifications.map(NotificationMapper::toResponse);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<NotificationResponse> getUnreadNotifications(Long userId, int page, int size) {

        validateUser(userId);
        Pageable pageable = createPageable(page,size);
        Page<Notification> notifications = notificationRepository.findByUser_IdAndStatus(userId,
                NotificationStatus.UNREAD,pageable);

        return notifications.map(NotificationMapper::toResponse);
    }

    @Override
    @Transactional(readOnly = true)
    public Long getUnreadNotificationCount(Long userId) {
        validateUser(userId);
        return notificationRepository.countByUser_IdAndStatus(userId,NotificationStatus.UNREAD);
    }

    @Override
    @Transactional
    public NotificationResponse markAsRead(Long notificationId, Long userId) {

        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(
                        ()-> new RuntimeException("Notification not found : " + notificationId)
                );

        validateOwnership(notification, userId);

        if(notification.getStatus().equals(NotificationStatus.UNREAD))
        {
            notification.setStatus(NotificationStatus.READ);
            notification.setReadAt(LocalDateTime.now());
            notificationRepository.save(notification);
        }


        return NotificationMapper.toResponse(notification);
    }

    private void validateOwnership(Notification notification, Long userId) {

        if(!notification.getUser().getId().equals(userId))
        {
            throw new RuntimeException(
                    "You do not have access to this notification"
            );
        }

    }

    @Override
    @Transactional
    public void markAllRead(Long userId) {

        validateUser(userId);
        Pageable pageable = PageRequest.of(0,Integer.MAX_VALUE);

        Page<Notification> notifications = notificationRepository.findByUser_Id(userId,pageable);

        notifications.getContent().forEach( notification -> {
            notification.setStatus(NotificationStatus.READ);
            notification.setReadAt(LocalDateTime.now());
        });

        notificationRepository.saveAll(notifications.getContent());

    }

    @Override
    @Transactional
    public void deleteNotification(Long notificationId, Long userId) {

        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(
                        ()->  new RuntimeException("notification not found")
                );

        validateOwnership(notification,userId);

        notificationRepository.delete(notification);

    }

    private Pageable createPageable(int page,int size)
    {
        return PageRequest.of(page,size,
                Sort.by(Sort.Direction.ASC,"createdAt"
                )
        );
    }
}
