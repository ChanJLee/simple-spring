package com.chan;

import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/hello")
    public HttpEntity<Greeting> sayHello(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        Greeting greeting = new Greeting("hello, " + name);
        GreetingController controller = ControllerLinkBuilder.methodOn(GreetingController.class);
        printInfo(controller.getClass());
        System.out.println("========================");
        Object o = controller.sayHello(name);
        //printInfo(o.getClass());
        greeting.add(ControllerLinkBuilder.linkTo(o).withSelfRel());
        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }

    private static void printInfo(Class<?> clazz) {
        System.out.println("print class " + clazz.getCanonicalName());
        Class<?> interfaces[] = clazz.getInterfaces();
        for (int i = 0; interfaces != null && i < interfaces.length; ++i) {
            System.out.println("interface: " + interfaces[i].getCanonicalName());
        }

        Class<?> parent = clazz.getSuperclass();
        if (parent != null) {
            System.out.println("parent: " + parent.getCanonicalName());
            printInfo(parent);
        }
    }
}
