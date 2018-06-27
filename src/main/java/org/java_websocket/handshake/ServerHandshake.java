package org.java_websocket.handshake;

public interface ServerHandshake {
    short getHttpStatus();

    String getHttpStatusMessage();
}
