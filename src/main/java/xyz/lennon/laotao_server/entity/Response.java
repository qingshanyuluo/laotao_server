package xyz.lennon.laotao_server.entity;

import lombok.Data;

import java.util.Map;

@Data
public class Response {
    boolean success;
    Map<String, String> result;

    public Response(boolean success, Map<String, String> result) {
        this.success = success;
        this.result = result;
    }
}
