package com.example.algorithm.mianshi;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2020/11/27 21:27
 * @description: 48个客服，
 */
public class KeFu {

    //客户队列
    private static List<Client> clientQueue = new LinkedList<>();
    //坐席队列
    private static List<Signer> signerQueue = new LinkedList<>();

    private static class Client {
        //客户ID
        private String clientId;
        // 上一次坐席ID
        private String lastSignerId;
    }

    private static class Signer {
        private String signerId;//坐席ID
        private int count;//服务人数
    }

    //客户发起排队
    private void clientStart(Client client) {
        clientQueue.add(client);
    }

    //坐席上线
    private void signerUp(Signer signer) {
        signerQueue.add(signer);
    }

    //time job 定时任务
    private void timerJob() {
        if (clientQueue.isEmpty() || signerQueue.isEmpty()) {
            return;
        }
        for (Client client : clientQueue) {
            String lastSignerId = client.lastSignerId;
            //遍历
            for (Signer signer : signerQueue) {
                if (signer.signerId == lastSignerId && signer.count < 3) {
                    //如果符合条件，则客户和坐席同时出队
                    clientQueue.remove(client);
                    signerQueue.remove(signer);
                    signer.count++;
                }
            }
        }
    }

    //结束对话，坐席的服务人数-1，并重新入队
    private void done(Signer signer) {
        signer.count--;
        signerQueue.add(signer);
    }

    public static void main(String[] args) {
    }
}
