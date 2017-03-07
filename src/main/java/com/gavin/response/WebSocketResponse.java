package com.gavin.response;

/**
 * User: Gavin
 * E-mail: GavinChangCN@163.com
 * Desc:
 * Date: 2017-03-06
 * Time: 11:00
 */
public class WebSocketResponse {
    protected static final String TAG = "WebsocketResponse";

    private String responseMessage;

    public WebSocketResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
