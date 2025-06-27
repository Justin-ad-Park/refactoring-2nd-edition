package com.oopsolid.dip.notificationservice;

// 1. 추상화 계층 (인터페이스) - 상위와 하위 모듈 공통 의존점
public interface MessageSender {
    void sendMessage(String message);
}

