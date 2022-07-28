package ru.netology.repository;

public class NotFoundExceptions extends RuntimeException {
    public NotFoundExceptions(String msg) {
        super(msg);
    }
}
