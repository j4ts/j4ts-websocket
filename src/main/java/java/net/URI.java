package java.net;

public class URI {
    private final String uri;

    public URI(String uri) throws URISyntaxException {
        if (!uri.startsWith("ws://") && !uri.startsWith("wss://")) {
            throw new URISyntaxException(uri, "Not supported socket URI, need ws:// or wss:// prefix to connect");
        }

        this.uri = uri;
    }

    @Override
    public String toString() {
        return uri;
    }
}
