package com.example.etcd.client;

import com.google.protobuf.ByteString;
import com.ibm.etcd.api.KeyValue;
import com.ibm.etcd.api.RangeResponse;
import com.ibm.etcd.client.KvStoreClient;
import com.ibm.etcd.client.kv.KvClient;
import com.ibm.etcd.client.lease.LeaseClient;
import com.ibm.etcd.client.lock.LockClient;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2021/3/29 14:24
 * @description:
 */
public class JdEtcdClient implements IConfigCenter {

    private KvClient kvClient;
    private LeaseClient leaseClient;
    private LockClient lockClient;

    public JdEtcdClient(KvStoreClient kvStoreClient) {
        this.kvClient = kvStoreClient.getKvClient();
        this.leaseClient = kvStoreClient.getLeaseClient();
        this.lockClient = kvStoreClient.getLockClient();
    }

    @Override
    public void put(String key, String value) {
        kvClient.put(ByteString.copyFromUtf8(key), ByteString.copyFromUtf8(value));
    }

    @Override
    public String get(String key) {
        RangeResponse rangeResponse = kvClient.get(ByteString.copyFromUtf8(key)).sync();
        List<KeyValue> keyValues = rangeResponse.getKvsList();
        if (CollectionUtils.isEmpty(keyValues)) {
            return null;
        }
        return keyValues.get(0).getValue().toStringUtf8();
    }
}
