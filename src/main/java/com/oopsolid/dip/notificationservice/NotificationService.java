package com.oopsolid.dip.notificationservice;

// 3. 상위 모듈(정책/비즈니스 로직) - 인터페이스에 의존
public class NotificationService {
    private final MessageSender messageSender;

    // 생성자를 통한 의존성 주입
    public NotificationService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void notifyUser(String message) {
        messageSender.sendMessage(message); // 추상화된 메서드에 의존
    }
}