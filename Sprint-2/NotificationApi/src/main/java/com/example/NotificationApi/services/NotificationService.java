package com.example.NotificationApi.services;

import com.example.NotificationApi.dao.NotificationDao;
import com.example.NotificationApi.model.NotificationTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    private final NotificationDao notificationDao;

    @Autowired //autowiring to the interface
    public NotificationService(@Qualifier("notificationDAO") NotificationDao notificationDao) { //injecting to the actual constructor
        this.notificationDao = notificationDao;
    }
    public int addNotificationTemplate(NotificationTemplate notificationTemplate){
        //UUID id = UUID.randomUUID();
        return notificationDao.insertNotificationTemplate(notificationTemplate);
    }

    public List<NotificationTemplate> getNotificationTemplates(){
        return notificationDao.selectNotificationTemplates();
    }

}
