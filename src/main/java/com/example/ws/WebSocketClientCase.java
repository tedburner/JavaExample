package com.example.ws;

import org.java_websocket.WebSocket;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_17;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: lingjun.jlj
 * @date: 2020/5/29 09:25
 * @description:
 */
public class WebSocketClientCase {

    public static List<String> result = new ArrayList<>();
    public static String initmsg = "{'cmd':'login','data':{'username':'xinji','password':'PASSWORD'}}"
            .replaceAll("'", "\"").replaceAll("PASSWORD", "1402");

    public static void main(String[] args) throws URISyntaxException {
        Map<String, String> headers = new HashMap<>();
        headers.put("Sec-WebSocket-Extensions", "permessage-deflate; client_max_window_bits");
        headers.put("Sec-WebSocket-Key", "leYVDOk73PPvYNT+O5toQA==");
        headers.put("Sec-WebSocket-Protocol", "x-access-token, eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1ODczOTIzOTQsImlkIjo0LCJ0b2tlbiI6IjY4NmI1OTQxNTU2ZTQxNGE2ZDc0NmE2NyJ9.8n9ygZd0Xg1-iWLusoFMaieXi4DvVgwkwt-r1tKJmkQ");
        headers.put("Sec-WebSocket-Version", "13");
        // 以下请求头可以不用传
//        headers.put("Connection", "Upgrade");
//        headers.put("Upgrade", "websocket");
//        headers.put("Accept-Encoding", "gzip, deflate, br");
//        headers.put("Accept-Language", "zh-CN,zh;q=0.9");
//        headers.put("Cache-Control", "no-cache");
//        headers.put("Host", "cloud.iotsquare.xyz");
//        headers.put("Origin", "https://cloud.iotsquare.xyz");
//        headers.put("Pragma", "no-cache");
//        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.117 Safari/537.36");

        Draft draft = new Draft_17();
        draft.setParseMode(WebSocket.Role.CLIENT);
        new ZgxWssUtil(new URI("wss://signtest.yuuwei.com/websocket/statistics")
                , draft
                , headers
                , 10
        ) {

            @Override
            public void onClose(int arg0, String arg1, boolean arg2) {
                System.out.println(String.format("onClose:【%s】【%s】【%s】", arg0, arg1, arg2));
            }

            @Override
            public void onError(Exception arg0) {
                System.out.println(String.format("onError:%s", arg0));

            }

            @Override
            public void onMessage(String arg0) {
                if (!arg0.equals("pong")) {
                    result.add(arg0);
                    System.out.println(String.format("onMessage:%s", arg0));
                }
                this.send(arg0);
            }

            @Override
            public void onOpen(ServerHandshake arg0) {
                System.out.println(String.format("onOpen:%s", arg0));
                this.send(initmsg);
            }
        }.connect();
    }
}
