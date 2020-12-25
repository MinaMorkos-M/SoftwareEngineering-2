package com.example.NotificationApi.dao;

import com.example.NotificationApi.model.NotificationTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("notificationDAO") //ths class is saved as a repo.
public class MemoryNotificationTemplateDataAccessLayer implements NotificationDao{
    private static List<NotificationTemplate> allTemplates = new ArrayList<>();


    @Override
    public int insertNotificationTemplate(UUID ID, NotificationTemplate notificationTemplate) {
        allTemplates.add(new NotificationTemplate(ID , notificationTemplate.getSubject() , notificationTemplate.getContent() , notificationTemplate.getLanguage()));
        return 1;
    }

    @Override
    public List<NotificationTemplate> selectNotificationTemplates() {
        return allTemplates;
    }


}
