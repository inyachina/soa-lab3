package service;

import lombok.extern.slf4j.Slf4j;

import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

@Slf4j
@Stateless
public class CallingServiceImpl implements CallingService {
    private final String URL = "http://localhost:41579/api/v1";
    private Client client;

    @Override
    public <T> T get(String uri, Class<T> clazz) {
        client = ClientBuilder.newClient();
        T result = client.target(URL)
                .path(uri)
                .request(MediaType.APPLICATION_JSON)
                .get(clazz);
        client.close();
        return result;
    }

    @Override
    public <T> T put(String uri, T object) {
        client = ClientBuilder.newClient();
        T result = (T) client.target(URL)
                .path(uri)
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(object, MediaType.APPLICATION_JSON));
        client.close();
        return result;
    }
}
