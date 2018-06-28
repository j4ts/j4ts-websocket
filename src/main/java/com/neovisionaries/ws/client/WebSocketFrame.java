package com.neovisionaries.ws.client;

public class WebSocketFrame {
    private boolean fin = false;
    private int opcode = 0;
    private int closeCode;
    private String reason;

    public boolean getFin() {
        return fin;
    }

    public WebSocketFrame setFin(boolean fin) {
        this.fin = fin;
        return this;
    }

    public int getOpcode() {
        return this.opcode;
    }

    public WebSocketFrame setOpcode(int opcode) {
        this.opcode = opcode;
        return this;
    }

    public boolean isCloseFrame() {
        return this.opcode == 8;
    }

    public int getCloseCode() {
        return closeCode;
    }

    public String getCloseReason() {
        return reason == null ? "" : reason;
    }

    public WebSocketFrame setCloseFramePayload(int closeCode, String reason) {
        this.closeCode = closeCode;
        this.reason = reason;
        return this;
    }

    public static WebSocketFrame createCloseFrame() {
        return (new WebSocketFrame()).setFin(true).setOpcode(8);
    }

    public static WebSocketFrame createCloseFrame(int closeCode) {
        return createCloseFrame().setCloseFramePayload(closeCode, null);
    }

    public static WebSocketFrame createCloseFrame(int closeCode, String reason) {
        return createCloseFrame().setCloseFramePayload(closeCode, reason);
    }
}
