package ru.rogov.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;

@Component
public class GenerateURI {

    @Value("${url}")
    private String url;

    public URI generateURI(String path) {
        try {
            URI uri = new URI(url + path);
            return uri;
        } catch (URISyntaxException e) {
            e.printStackTrace();
            throw new RuntimeException("Не удалось сгенерировать URI" + e);
        }
    }

}
