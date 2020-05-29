package com.example.ws;

import org.java_websocket.client.DefaultSSLWebSocketClientFactory;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.handshake.ServerHandshake;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.net.URI;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;

/**
 * @author: lingjun.jlj
 * @date: 2020/5/29 09:26
 * @description:
 */
public class ZgxWssUtil extends WebSocketClient {

    public ZgxWssUtil(URI serverURI) {
        super(serverURI);
        if (serverURI.toString().contains("wss://"))
            trustAllHosts(this);
    }

    public ZgxWssUtil(URI serverURI, Draft draft) {
        super(serverURI, draft);
        if (serverURI.toString().contains("wss://"))
            trustAllHosts(this);
    }

    public ZgxWssUtil(URI serverURI, Draft draft, Map<String, String> headers, int connecttimeout) {
        super(serverURI, draft, headers, connecttimeout);
        if (serverURI.toString().contains("wss://"))
            trustAllHosts(this);
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        System.out.println("ws 建立连接");
    }

    @Override
    public void onMessage(String s) {
        System.out.println(String.format("ws 客户端接收到消息：%s", s));
    }

    @Override
    public void onClose(int i, String s, boolean b) {
        System.out.println("ws 关闭连接");
    }

    @Override
    public void onError(Exception e) {
        System.out.println("连接出现异常");
    }

    final static HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() {
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    };


    static void trustAllHosts(ZgxWssUtil appClient) {
        System.out.println("start...");
        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return new java.security.cert.X509Certificate[]{};
            }

            @Override
            public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                // TODO Auto-generated method stub

            }

            @Override
            public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                // TODO Auto-generated method stub

            }
        }};

        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            appClient.setWebSocketFactory(new DefaultSSLWebSocketClientFactory(sc));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
