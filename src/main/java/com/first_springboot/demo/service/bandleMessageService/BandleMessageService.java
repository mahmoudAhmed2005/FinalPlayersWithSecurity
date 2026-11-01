package com.first_springboot.demo.service.bandleMessageService;

import com.first_springboot.demo.helper.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class BandleMessageService {

    @Autowired
    private ResourceBundleMessageSource resourceBundleMessageSource;

    public String getMessageAR(String code ){

        return resourceBundleMessageSource.getMessage(code,null,new Locale("ar"));

    }





    public String getMessageEN(String code ){

        return resourceBundleMessageSource.getMessage(code,null,new Locale("en"));

    }






    public MessageResponse getMessage(String code ){

        return new MessageResponse(getMessageAR(code),getMessageEN(code));

    }





}
