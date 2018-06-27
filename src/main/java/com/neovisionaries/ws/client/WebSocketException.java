package com.neovisionaries.ws.client;

public class WebSocketException extends Exception {
    public WebSocketException(String s) {
        super(s);
    }

    public WebSocketException(Throwable throwable) {
        super(throwable);
    }
}
