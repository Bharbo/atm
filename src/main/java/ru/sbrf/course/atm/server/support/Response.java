package ru.sbrf.course.atm.server.support;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Response {
    boolean status;
    String message;
    Object addition;

    public Response(boolean status) {
        this.status = status;
    }

    public Response(boolean status, String message) {
        this.status = status;
        this.message = message;
    }
}
