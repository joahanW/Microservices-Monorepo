package com.johan.notification;

import com.johan.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Slf4j
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public void sendNotification(NotificationRequest notificationRequest){
        notificationRepository.save(
                Notification.builder()
                        .toCustomerId(notificationRequest.toCustomerId())
                        .toCustomerEmail(notificationRequest.toCustomerEmail())
                        .message(notificationRequest.message())
                        .sender("johan@gmail.com")
                        .sentAt(LocalDateTime.now())
                        .build()
        );
        log.info("Notification already send to customer Id : {} and Email: {}",
                notificationRequest.toCustomerId(), notificationRequest.toCustomerEmail()
        );
    }

}
