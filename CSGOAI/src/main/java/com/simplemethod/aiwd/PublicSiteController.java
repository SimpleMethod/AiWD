package com.simplemethod.aiwd;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublicSiteController {


    @GetMapping("/")
    public String mission() {
        return "aiwebsite";
    }

}
