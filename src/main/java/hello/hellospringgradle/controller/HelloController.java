package hello.hellospringgradle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "Spring!!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(
            @RequestParam(name = "name", required = false)
                    String name, Model model)
    {
        model.addAttribute("name",name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "Hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        // make an object (객체를 만들다)
        // cmd shift enter -> auto finish
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        // Getter & Setter Encapsulation (OOPS)
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}
