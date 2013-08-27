package com.wxd.websocket;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;
import com.wxd.websocket.bean.Message;

public class MessageEncoder implements Encoder.Text<Message> {
    
    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void init(EndpointConfig arg0) {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public String encode(Message message) throws EncodeException {
        Gson gson = new Gson();
        return gson.toJson(message);
    }
    
}
