package com.neovisionaries.ws.client;

import java.util.List;
import java.util.Map;

public interface WebSocketListener {
    void onConnected(WebSocket webSocket, Map<String, List<String>> headers) throws Exception;

    void onError(WebSocket webSocket, WebSocketException exception) throws Exception;

    void onTextMessage(WebSocket webSocket, String message) throws Exception;

    void onBinaryMessage(WebSocket websocket, byte[] binary) throws Exception;

    void onDisconnected(WebSocket websocket, WebSocketFrame serverCloseFrame, WebSocketFrame clientCloseFrame, boolean closedByServer) throws Exception;
}
