package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /**
     * This @CrossOrigin annotation enables cross-origin requests only for this specific method. 
     * By default, its allows all origins, all headers, the HTTP methods specified 
     * in the @RequestMapping annotation and a maxAge of 30 minutes is used. 
     * You can customize this behavior by specifying the value of one of the annotation 
     * attributes: origins, methods, allowedHeaders, exposedHeaders, allowCredentials or maxAge. 
     * In this example, we only allow http://localhost:9000 to send cross-origin request
     * @param name
     * @return
     */
    @CrossOrigin(origins = "http://localhost:9000")
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(required=false, defaultValue="World") String name) {
        System.out.println("==== in greeting ====");
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
    
    @GetMapping("/greeting-javaconfig")
    public Greeting greetingWithJavaconfig(@RequestParam(required=false, defaultValue="World") String name) {
        System.out.println("==== in greeting ====");
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

}