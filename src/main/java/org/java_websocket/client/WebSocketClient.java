package org.java_websocket.client;

import def.dom.WebSocket;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

public abstract class WebSocketClient {
    private final URI uri;
    private WebSocket webSocket;
    private Exception cachedException;
    private boolean weClosed = false;

    public WebSocketClient(URI uri) {
        this.uri = uri;
    }

    protected abstract void onOpen(ServerHandshake handshake);

    protected abstract void onMessage(String message);

    protected abstract void onClose(int code, String reason, boolean remote);

    protected abstract void onError(Exception exception);

    public void connect() {
        webSocket = new WebSocket(uri.toString());

        webSocket.onopen = e -> {
            onOpen(null);
            return e;
        };
        webSocket.onmessage = e -> {
            onMessage(e.origin);
            return e;
        };

        webSocket.onclose = e -> {
            onClose((int) e.code, e.reason, weClosed);
            return e;
        };

        webSocket.onerror = e -> {
            onError(cachedException);
            return e;
        };
    }

    public void close(int code, String message) {
        weClosed = true;
        try {
            webSocket.close(code, message);
        } catch (Exception e) {
            cachedException = e;
        }
    }

    public void close() {
        close(-1, "End of WebSocketClient");
    }

    public void send(String message) {
        try {
            webSocket.send(message);
        } catch (Exception e) {
            cachedException = e;
        }
    }
}
