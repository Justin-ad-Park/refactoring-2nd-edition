package com.oopsolid.dip.notificationservice;

import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class NotificationServiceTest {

    @Test
    void testNotifyUser() {
        MessageSender mockSender = mock(MessageSender.class);
        NotificationService service = new NotificationService(mockSender);

        service.notifyUser("Test Message");

        verify(mockSender, atLeastOnce()).sendMessage(anyString());
    }
}