package soa.lab.service;

public interface CallingService {

    <T> T get(String uri, Class<T> clazz);

    <T> T put(String uri, T object);

}
