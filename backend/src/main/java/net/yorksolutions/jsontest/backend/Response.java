package net.yorksolutions.jsontest.backend;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Response {

    @Id
    @JsonProperty
    int id;

    @JsonProperty
    String echo;

    public Response(int id, String echo) {
        this.echo = echo;
        this.id = id;
    }
}
