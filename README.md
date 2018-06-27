# j4ts-java-websocket
A JSweet implementation for https://github.com/TakahikoKawasaki/nv-websocket-client websocket client


example:
```

import com.neovisionaries.ws.client.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class Echo {
    public static void main( String[] args ) throws IOException, WebSocketException, URISyntaxException {
        WebSocket socket = new WebSocketFactory().createSocket(new URI("wss://echo.websocket.org"));

        socket.addListener(new WebSocketAdapter() {
            @Override
            public void onConnected(WebSocket webSocket, Map<String, List<String>> map) {
                System.err.println("connected");
                webSocket.sendText("megy");
            }

            @Override
            public void onDisconnected(WebSocket webSocket, WebSocketFrame webSocketFrame, WebSocketFrame webSocketFrame1, boolean b) {
                System.err.println("Disconnected");
            }

            @Override
            public void onTextMessage(WebSocket webSocket, String s) {
                System.err.println("text message: " + s);
            }

            @Override
            public void onError(WebSocket webSocket, WebSocketException e) {
                e.printStackTrace();
                System.err.println("error ");
            }
        });
        socket.connect();
    }
}
```
