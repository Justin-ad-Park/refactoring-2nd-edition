package com.oopsolid.dip.notificationservice;

// 2. 하위 모듈(구현 세부) - 인터페이스 구현
public class EmailSender implements MessageSender {
    @Override
    public void sendMessage(String message) {
        // 이메일 전송 로직 (세부 구현)
        System.out.println("Email sent: " + message);
    }
}