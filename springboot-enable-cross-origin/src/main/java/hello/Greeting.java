package hello;

/**
 * As you see in steps below, Spring uses the Jackson JSON library 
 * to automatically marshal instances of type Greeting into JSON.
 * Thanks to Spring’s HTTP message converter support, you don’t need to do this conversion manually. 
 * Because Jackson is on the classpath, Spring’s MappingJackson2HttpMessageConverter is 
 * automatically chosen to convert the Greeting instance to JSON
 */
public class Greeting {

    private final long id;
    private final String content;

    public Greeting() {
        this.id = -1;
        this.content = "";
    }

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}