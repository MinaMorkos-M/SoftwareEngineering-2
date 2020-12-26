package com.example.NotificationApi.API;

import com.example.NotificationApi.model.NotificationTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.NotificationApi.services.NotificationService;
import org.springframework.web.servlet.theme.CookieThemeResolver;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/notificationTemplate") //endpoint is created
@RestController //to be a rest controller to use CRUD
public class NotificationTemplatesController {
    private final NotificationService notificationService;

    @Autowired
    public NotificationTemplatesController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
    @PostMapping //to be used as a post method
    public void addNotificationTemplate(@Validated @NonNull @RequestBody NotificationTemplate notificationTemplate){ //convert json into notificationTemplate
        notificationService.addNotificationTemplate(notificationTemplate);
    }

    @GetMapping
    public List<NotificationTemplate> getNotificationTemplates(){
        return notificationService.getNotificationTemplates();
    }

    @GetMapping(path="{ID}") //actual id in path
    public NotificationTemplate getNotificationTemplate(@PathVariable("ID") UUID ID){
        return notificationService.getNotificationTemplate(ID).orElse(null); //message not found

    }

    @DeleteMapping(path = "{ID}")
    public void deleteNotificationTemplate(@PathVariable("ID") UUID ID){
        notificationService.deleteNotificationTemplate(ID);
    }

    @PutMapping(path = "{ID}")
    public void updateNotificationTemplate(@PathVariable("ID") UUID ID ,@Validated @NonNull @RequestBody NotificationTemplate notificationTemplate){
        notificationService.updateNotificationTemplate(ID , notificationTemplate);
    }
}
