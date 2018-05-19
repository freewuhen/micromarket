package com.freeyun.micromarket.Domain;

import java.io.Serializable;
//交易记录的组合主键
public class TRMultikey implements Serializable { // 不要忘记序列化
    private String uid;
    private String cid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }
}
