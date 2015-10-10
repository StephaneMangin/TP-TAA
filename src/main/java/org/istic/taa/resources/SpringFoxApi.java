package org.istic.taa.resources;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by stephane on 09/10/15.
 */
@Controller
public class SpringFoxApi {

    @RequestMapping("/resources")
    public String entryPoint() {
        return "redirect:swagger-resources";
    }
}
