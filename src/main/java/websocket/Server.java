package com.wxd.websocket;

import java.util.logging.Logger;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.wxd.websocket.bean.Message;

@ServerEndpoint(value = "/chat/{room}", decoders = { MessageDecoder.class }, encoders = { MessageEncoder.class })
public class Server {
    
    private final Logger log = Logger.getLogger(this.toString());
    
    @OnOpen
    public void onOpen(Session session, @PathParam("room")
    String room) {
        log.info("session openend and bound to room: " + room);
        session.getUserProperties().put("room", room);
        System.out.println(room);
    }
    
    @OnMessage
    public void onMessage(Session session, Message message) {
        log.info(message.toString());
        String room = (String) session.getUserProperties().get("room");
        broadcast(session, message, room);
    }
    
    @OnClose
    public void onClose(Session session) {
        System.out.println("close");
    }
    
    @OnError
    public void onError(Throwable t) {
        t.printStackTrace();
    }
    
    private void broadcast(Session session, Message message, String room) {
        try {
            
            for (Session s : session.getOpenSessions()) {
                if (s.isOpen() && room.equals(s.getUserProperties().get("room"))) {
                    s.getBasicRemote().sendObject(message);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
