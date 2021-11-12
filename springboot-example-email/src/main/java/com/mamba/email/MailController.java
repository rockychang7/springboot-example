package com.mamba.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author JoeBig7
 * @date 2021/11/12 16:06:01
 */
@RestController
public class MailController {

    @Autowired
    private EmailServiceImpl emailService;

    @PostMapping("/send")
    public boolean send(@RequestBody SendRequest sendRequest) {
        emailService.sendSimpleMessage(sendRequest.getTo(), sendRequest.getSubject(), sendRequest.getText());
        return true;
    }
}
