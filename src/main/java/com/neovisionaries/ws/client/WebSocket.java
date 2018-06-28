package com.neovisionaries.ws.client;

import jsweet.util.Lang;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;

import static def.dom.Globals.window;
import static jsweet.util.Lang.$new;

public class WebSocket {
    private final URI uri;
    private final ArrayList<WebSocketListener> listeners = new ArrayList<>();

    private def.js.Object domWebSocket;

    private WebSocketException cacheException;
    private boolean closedManually = false;

    static private def.js.Object jsWebSocketClass() {
        return (def.js.Object) window.$get("WebSocket");
    }

    WebSocket(URI uri) {
        this.uri = uri;
    }

    public WebSocket addListener(WebSocketListener listener) {
        listeners.add(listener);
        return this;
    }

    public WebSocket removeListener(WebSocketListener listener) {
        listeners.remove(listener);
        return this;
    }

    public WebSocket clearListeners() {
        listeners.clear();
        return this;
    }

    public WebSocket connect() throws WebSocketException {
        try {
            this.domWebSocket = $new(jsWebSocketClass(), uri.toString());
        } catch (Throwable e) {
            throw new WebSocketException(e);
        }

        Lang.<def.dom.WebSocket> any(this.domWebSocket).onopen = e -> {
            for (WebSocketListener listener : listeners) {
                try {
                    listener.onConnected(this, Collections.emptyMap());
                } catch (Exception e1) {
                    cacheException = new WebSocketException(e1);
                }
            }
            return e;
        };

        Lang.<def.dom.WebSocket> any(this.domWebSocket).onmessage = e -> {
            for (WebSocketListener listener : listeners) {
                try {
                    listener.onTextMessage(this, e.data.toString());
                } catch (Exception e1) {
                    cacheException = new WebSocketException(e1);
                }
            }
            return e;
        };

        Lang.<def.dom.WebSocket> any(this.domWebSocket).onerror = e -> {
            for (WebSocketListener listener : listeners) {
                try {
                    listener.onError(this, cacheException == null ? new WebSocketException("No exception, sorry. Event: " + e.type) : cacheException);
                } catch (Exception e1) {
                    cacheException = new WebSocketException(e1);
                }
            }
            return e;
        };

        Lang.<def.dom.WebSocket> any(this.domWebSocket).onclose = e -> {
            for (WebSocketListener listener : listeners) {
                try {
                    WebSocketFrame closeFrame = WebSocketFrame.createCloseFrame((int) e.code, e.reason);
                    listener.onDisconnected(this, closeFrame, closeFrame, !closedManually);
                } catch (Exception e1) {
                    cacheException = new WebSocketException(e1);
                }
            }
            return e;
        };

        return this;
    }

    public WebSocket sendText(String text) {
        try {
            Lang.<def.dom.WebSocket> any(this.domWebSocket).send(text);
        } catch (Throwable e) {
            cacheException = new WebSocketException(e);
        }
        return this;
    }

    public WebSocket sendClose() {
        closedManually = true;
        Lang.<def.dom.WebSocket> any(this.domWebSocket).close();
        return this;
    }

    public WebSocket sendClose(int closeCode, String reason) {
        closedManually = true;
        Lang.<def.dom.WebSocket> any(this.domWebSocket).close(closeCode, reason);
        return this;
    }
}
