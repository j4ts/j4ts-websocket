package com.neovisionaries.ws.client;

import java.io.IOException;
import java.net.URI;

public class WebSocketFactory {
    public WebSocketFactory() {

    }

    public WebSocket createSocket(String uri) throws IOException {
        return createSocket(URI.create(uri));
    }

    public WebSocket createSocket(URI uri) throws IOException {
        return new WebSocket(uri);
    }
}
