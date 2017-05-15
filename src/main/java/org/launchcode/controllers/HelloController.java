package org.launchcode.controllers;

import org.launchcode.models.HelloMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.RequestWrapper;
import java.util.Map;

/**
 * Created by J on 3/6/2017.
 */
@Controller
public class HelloController {

    @RequestMapping(value = "")
    @ResponseBody
    public String index(@RequestParam(defaultValue = "World")String name) {
        return "Hello " + name;
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloForm() {

        String html =
                "<form method='post'>" +
                "<input type='text' name='name' />" +
                "<select name='language'>";

        for (Map.Entry<String, String> option : HelloMessage.getLanguages().entrySet()){
            String key = option.getKey();
            html += "<option name='" + key + "'>" + key + "</option>";
        }

         html += "<input type='submit' value='Greet Me!' />" +
                "</form>";

        return html;
    }
    @RequestMapping(value = "hello", method= RequestMethod.POST)
    @ResponseBody
    public String helloPost(HttpServletRequest request) {


        String name = request.getParameter("name");
        String language = request.getParameter("language");
        return HelloMessage.createMessage(name, language);

    }

    @RequestMapping(value = "hello/{name}")
    @ResponseBody
    public String helloUrlSegment(@PathVariable String name) {

        return "Hello " + name;

    }


    @RequestMapping(value = "goodbye")
    public String goodbye() {
        return "redirect:/";
    }


}

