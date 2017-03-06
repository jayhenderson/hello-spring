package org.launchcode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.RequestWrapper;

/**
 * Created by J on 3/6/2017.
 */
@Controller
public class HelloController {

    @RequestMapping(value = "")
    @ResponseBody
    public String index(HttpServletRequest request) {

        String username = request.getParameter("name");

        if (username == null) {
            username = "World";
        }

        return "Hello " + username;
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloForm() {

        String html = "<form method='post'>" +
                "<input type='text' name='name' />" +
                "<input type='submit' value='Greet Me!' />" +
                "</form>";

        return html;
    }
    @RequestMapping(value = "hello", method= RequestMethod.POST)
    @ResponseBody
    public String helloPost(HttpServletRequest request) {


        String name = request.getParameter("name");

        return "Hello " + name;

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
