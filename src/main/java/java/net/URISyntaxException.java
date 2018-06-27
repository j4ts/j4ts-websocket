package java.net;

public class URISyntaxException extends Exception {
    private final String input;
    URISyntaxException(String input, String reason) {
        super(reason);
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public String getReason() {
        return getMessage();
    }

    public String getMessage() {
        return getReason() + ": " + input;
    }
}
