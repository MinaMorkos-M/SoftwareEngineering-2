package com.example.NotificationApi.API;

import com.example.NotificationApi.model.NotificationTemplate;
import com.example.NotificationApi.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.example.NotificationApi.model.NotificationType.MAIL;
import static com.example.NotificationApi.model.NotificationType.SMS;

@RequestMapping("/api/notificationTemplate") //endpoint is created
@RestController //to be a rest controller to use CRUD
public class NotificationTemplatesController {
    private final NotificationService notificationService;


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    public NotificationTemplatesController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
    @PostMapping //to be used as a post method
    public void addNotificationTemplate(@Validated @NonNull @RequestBody NotificationTemplate notificationTemplate){ //convert json into notificationTemplate
        //jdbcTemplate.queryForList("INSERT INTO templates(ID , subject , content , language) VALUES (?,?,?,?)");
        String query = "INSERT INTO templates (id, subject, content , language) VALUES ('"+notificationTemplate.getID()+"','"+notificationTemplate.getSubject()+"','"+notificationTemplate.getContent()+"','"+notificationTemplate.getLanguage()+"')";
        jdbcTemplate.update(query);
        if(notificationTemplate.getNotificationType()==SMS){
            String query2 = "INSERT INTO sms (id, subject, content , language) VALUES ('"+notificationTemplate.getID()+"','"+notificationTemplate.getSubject()+"','"+notificationTemplate.getContent()+"','"+notificationTemplate.getLanguage()+"')";
            jdbcTemplate.update(query2);
        }
        else if(notificationTemplate.getNotificationType()==MAIL){
            String query3 = "INSERT INTO mail (id, subject, content , language) VALUES ('"+notificationTemplate.getID()+"','"+notificationTemplate.getSubject()+"','"+notificationTemplate.getContent()+"','"+notificationTemplate.getLanguage()+"')";
            jdbcTemplate.update(query3);
        }
        //notificationService.addNotificationTemplate(notificationTemplate);

    }

    @GetMapping
    public String /*List<NotificationTemplate>*/ getNotificationTemplates(){
        return jdbcTemplate.queryForList("SELECT * FROM  templates ").toString();
        //return notificationService.getNotificationTemplates();
    }

    @GetMapping(path="{ID}") //actual id in path
    public String /*NotificationTemplate*/ getNotificationTemplate(@PathVariable("ID") UUID ID){
        //return notificationService.getNotificationTemplate(ID).orElse(null); //message not found
        String query = "SELECT * FROM templates WHERE id='"+ID+"'";
        return jdbcTemplate.queryForList(query).toString();
    }

    @DeleteMapping(path = "{ID}")
    public void deleteNotificationTemplate(@PathVariable("ID") UUID ID){
        //notificationService.deleteNotificationTemplate(ID);
        String query = "DROP * FROM templates WHERE id='"+ID+"'";
        jdbcTemplate.queryForList(query);
    }

    @PutMapping(path = "{ID}")
    public void updateNotificationTemplate(@PathVariable("ID") UUID ID ,@Validated @NonNull @RequestBody NotificationTemplate notificationTemplate){
        notificationService.updateNotificationTemplate(ID , notificationTemplate);
    }
}