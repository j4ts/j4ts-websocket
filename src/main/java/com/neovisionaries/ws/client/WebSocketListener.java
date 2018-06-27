package com.neovisionaries.ws.client;

import java.util.List;
import java.util.Map;

public interface WebSocketListener {
    void onConnected(WebSocket webSocket, Map<String, List<String>> map) throws Exception;

    void onError(WebSocket webSocket, WebSocketException e) throws Exception;

    void onTextMessage(WebSocket webSocket, String s) throws Exception;

    void onDisconnected(WebSocket websocket, WebSocketFrame serverCloseFrame, WebSocketFrame clientCloseFrame, boolean closedByServer) throws Exception;
}
