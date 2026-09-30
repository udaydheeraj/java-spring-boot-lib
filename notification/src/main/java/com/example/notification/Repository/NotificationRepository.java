package com.example.notification.Repository;


import com.example.notification.entity.Notification;
import com.example.notification.entity.NotificationStatus;
import com.example.notification.entity.NotificationType;
import com.example.notification.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository
        extends JpaRepository<Notification, Long> {

    Page<Notification> findByUser_Id(Long userId, Pageable pageable);

    Page<Notification> findByUser_IdAndStatus(
            Long userId,
            NotificationStatus status,
            Pageable pageable
    );

    Long countByUser_IdAndStatus(
            Long userId,
            NotificationStatus status
    );

    Page<Notification> findByUser_IdAndType(
            Long userId,
            NotificationType type,
            Pageable pageable
    );

}
