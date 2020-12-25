package com.example.NotificationApi.API;

import com.example.NotificationApi.model.NotificationTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.NotificationApi.services.NotificationService;

import java.util.List;

@RequestMapping("/api/notificationTemplate") //endpoint is created
@RestController //to be a rest controller to use CRUD
public class NotificationTemplatesController {
    private final NotificationService notificationService;

    @Autowired
    public NotificationTemplatesController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
    @PostMapping //to be used as a post method
    public void addNotificationTemplate(@RequestBody NotificationTemplate notificationTemplate){ //convert json into notificationTemplate
        notificationService.addNotificationTemplate(notificationTemplate);
    }

    @GetMapping
    public List<NotificationTemplate> getNotificationTemplates(){
        return notificationService.getNotificationTemplates();
    }
}
