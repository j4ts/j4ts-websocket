package java.net;

public class URI {
    private final String uriString;

    public URI(String uriString) throws URISyntaxException {
        if (!uriString.startsWith("ws://") && !uriString.startsWith("wss://")) {
            throw new URISyntaxException(uriString, "Not supported socket URI, need ws:// or wss:// prefix to connect");
        }

        this.uriString = uriString;
    }

    @Override
    public String toString() {
        return uriString;
    }
}
