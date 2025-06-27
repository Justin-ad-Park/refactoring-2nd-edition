package com.oopsolid.dip.notificationservice;

public class NotificationApplication {
    // 사용 예시 (main 등)
    public static void main(String[] args) {
        MessageSender sender = new EmailSender(); // 하위 모듈
        NotificationService service = new NotificationService(sender); // 상위 모듈
        service.notifyUser("Hello, user!");
    }
}
