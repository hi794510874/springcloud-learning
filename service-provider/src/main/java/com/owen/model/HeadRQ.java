package com.owen.model;

import java.io.Serializable;

/**
 * Created by huang_b on 2017/9/15.
 */
public class HeadRQ  implements Serializable {
    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getClientToken() {
        return clientToken;
    }

    public void setClientToken(String clientToken) {
        this.clientToken = clientToken;
    }

    public String clientID ;


    public String clientToken ;
}
