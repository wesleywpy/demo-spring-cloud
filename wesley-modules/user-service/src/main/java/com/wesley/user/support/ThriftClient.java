package com.wesley.user.support;

import com.wesley.thrift.user.UserService;
import lombok.Data;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * <p>
 *
 * </p>
 *
 * @author Created by Yani on 2019/12/02
 */
@Data
public class ThriftClient {
    private TBinaryProtocol protocol;

    private TSocket transport;

    private String host;

    private int port;

    private UserService.Client userServiceClient;

    public void init() {
        transport = new TSocket(host, port);
        protocol = new TBinaryProtocol(transport);
        userServiceClient = new UserService.Client(protocol);
    }

    public void open() throws TTransportException {
        transport.open();
    }

    public void close() {
        transport.close();
    }
}
