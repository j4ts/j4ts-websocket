package com.neovisionaries.ws.client;

import java.util.List;
import java.util.Map;

public class WebSocketAdapter implements WebSocketListener {
    @Override
    public void onConnected(WebSocket webSocket, Map<String, List<String>> headers) throws Exception {

    }

    @Override
    public void onError(WebSocket webSocket, WebSocketException exception) throws Exception {

    }

    @Override
    public void onTextMessage(WebSocket webSocket, String message) throws Exception {

    }

    @Override
    public void onDisconnected(WebSocket websocket, WebSocketFrame serverCloseFrame, WebSocketFrame clientCloseFrame, boolean closedByServer) throws Exception {

    }

    @Override
    public void onBinaryMessage(WebSocket websocket, byte[] binary) throws Exception {

    }
}
