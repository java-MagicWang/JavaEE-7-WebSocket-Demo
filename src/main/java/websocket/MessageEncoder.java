package com.wxd.websocket;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import com.wxd.websocket.bean.Message;


public class MessageEncoder implements Encoder.Text<Message>{

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void init(EndpointConfig arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String encode(Message arg0) throws EncodeException {
        // TODO Auto-generated method stub
        return null;
    }
    
}
