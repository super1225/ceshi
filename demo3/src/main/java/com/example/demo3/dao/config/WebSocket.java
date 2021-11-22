
package com.example.demo3.dao.config;

import com.example.demo3.dao.controller.Inner_socket;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.sql.Time;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;

@Component
@ServerEndpoint("/5_websocket")
//此注解相当于设置访问URL
public class WebSocket {

    private Session session;

    private static CopyOnWriteArraySet<WebSocket> webSockets =new CopyOnWriteArraySet<>();
    private static Map<String,Session> sessionPool = new HashMap<String,Session>();

    @OnOpen
    public void onOpen(Session session, @PathParam(value="shopId")String shopId) throws InterruptedException {
        this.session = session;
        webSockets.add(this);
        sessionPool.put(shopId, session);
        while(true)
        {
            System.out.println("【websocket消息】有新的连接，总数为:"+webSockets.size());
            //if(Inner_socket.web() == 0)
            sendAllMessage("hello5");
            TimeUnit.SECONDS.sleep(30);
        }

    }

    @OnClose
    public void onClose() {
        webSockets.remove(this);
        System.out.println("【websocket消息】连接断开，总数为:"+webSockets.size());
    }

    @OnMessage
    public void onMessage(String message) {
        System.out.println("【websocket消息】收到客户端消息:"+message);
        if(Inner_socket.web() == 0)
            sendAllMessage("课题5收到");
    }

    // 此为广播消息
    public void sendAllMessage(String message) {
        for(WebSocket webSocket : webSockets) {
            System.out.println("【websocket消息】广播消息:"+message);
            try {
                webSocket.session.getAsyncRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 此为单点消息 (发送文本)
    public void sendTextMessage(String shopId, String message) {
        Session session = sessionPool.get(shopId);
        if (session != null) {
            try {
                session.getBasicRemote().sendText("课题5收到");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 此为单点消息 (发送对象)
    public void sendObjMessage(String shopId, Object message) {
        Session session = sessionPool.get(shopId);
        if (session != null) {
            try {
                session.getAsyncRemote().sendObject(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}


