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
            public void onConnected(WebSocket webSocket, Map<String, List<String>> headers) {
                System.err.println("connected");
                webSocket.sendText("megy");
            }

            @Override
            public void onDisconnected(WebSocket webSocket, WebSocketFrame serverCloseFrame, 
                    WebSocketFrame clientCloseFrame, boolean closedByServer) {
                System.err.println("Disconnected with code/status: " + serverCloseFrame.getCloseCode() 
                    + "/" + serverCloseFrame.getCloseReason());
            }

            @Override
            public void onTextMessage(WebSocket webSocket, String message) {
                System.err.println("text message: " + message);
            }

            @Override
            public void onError(WebSocket webSocket, WebSocketException exception) {
                exception.printStackTrace();
                System.err.println("error ");
            }
        });
        socket.connect();
    }
}
```

add maven dependency to your repo, and you can use it java such as javascript side
```
<dependency>
    <groupId>com.neovisionaries</groupId>
    <artifactId>nv-websocket-client</artifactId>
    <version>2.5</version>
</dependency>
```
