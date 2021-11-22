/*
package com.example.demo3.dao.service;

import com.example.demo3.dao.config.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WebSocketXdxService {

    @Autowired
    private WebSocket webSocket;

    public Object xdxTest(String shipId) throws InterruptedException {
        for (int i = 0; i < 10; i++){
            Thread.sleep(1000);
            webSocket.sendTextMessage(shipId, "课题5收到消息");
        }
        return null;
    }
}
*/
