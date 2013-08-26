package com.wxd.websocket;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/chat/{room}", decoders = { MessageDecoder.class }, encoders = { MessageEncoder.class })
public class Server {
    
    @OnOpen
    public void onOpen(@PathParam("room")
    String room) {
        System.out.println("open");
        System.out.println(room);
    }
    
    @OnMessage
    public void onMessage(Session session, String message) {
        System.out.println(message);
    }
    
    @OnClose
    public void onClose() {
        System.out.println("close");
    }
    
    @OnError
    public void onError(Throwable t) {
        t.printStackTrace();
    }
}
