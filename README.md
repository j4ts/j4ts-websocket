# j4ts-java-websocket
A JSweet implementation for https://github.com/TooTallNate/Java-WebSocket websocket client


example:
```
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;

public class ExampleClient extends WebSocketClient {
    public ExampleClient( URI serverURI ) {
        super( serverURI );
    }

    @Override
    public void onOpen( ServerHandshake handshakedata ) {
        send("Hello, it is me. Mario :)");
    }

    @Override
    public void onMessage( String message ) {
        System.out.println( "received: " + message );
    }

    @Override
    public void onClose( int code, String reason, boolean remote ) {
        System.out.println( "Connection closed by " + ( remote ? "remote peer" : "us" ) + 
                " Code: " + code + " Reason: " + reason );
    }

    @Override
    public void onError( Exception ex ) {
        ex.printStackTrace();
    }

    public static void main( String[] args ) throws URISyntaxException {
        ExampleClient c = new ExampleClient( new URI( "wss://echo.websocket.org" ));
        c.connect();
    }
}
```
