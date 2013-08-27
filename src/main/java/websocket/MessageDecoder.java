package com.wxd.websocket;

import java.lang.reflect.Type;
import java.util.Date;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wxd.websocket.bean.Message;

public class MessageDecoder implements Decoder.Text<Message> {
    
    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void init(EndpointConfig arg0) {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public Message decode(String text) throws DecodeException {
        Message message = new Message();
        message = new Gson().fromJson(text, Message.class);
        message.setReceived(new Date());
        return message;
    }
    
    @Override
    public boolean willDecode(String arg0) {
        return true;
    }
    
}
