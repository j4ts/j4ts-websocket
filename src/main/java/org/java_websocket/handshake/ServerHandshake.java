package org.java_websocket.handshake;

public interface ServerHandshake {
    short getHttpStatus();

    String getHttpStatusMessage();

    String getFieldValue( String name );

    boolean hasFieldValue( String name );

    byte[] getContent();

    ServerHandshake EMPTY = new ServerHandshake() {
        @Override
        public short getHttpStatus() {
            return 0;
        }

        @Override
        public String getHttpStatusMessage() {
            return "";
        }

        @Override
        public String getFieldValue(String name) {
            return "";
        }

        @Override
        public boolean hasFieldValue(String name) {
            return false;
        }

        @Override
        public byte[] getContent() {
            return new byte[0];
        }
    };
}
