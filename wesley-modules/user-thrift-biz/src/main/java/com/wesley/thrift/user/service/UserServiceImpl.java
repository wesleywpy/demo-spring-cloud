package com.wesley.thrift.user.service;

import com.wesley.thrift.user.UserDTO;
import com.wesley.thrift.user.UserService;
import org.apache.thrift.TException;

/**
 * <p>
 *
 * </p>
 *
 * @author Created by Yani on 2019/11/27
 */
public class UserServiceImpl implements UserService.Iface {

    @Override
    public UserDTO getUserById(int id) throws TException {
        return null;
    }

    @Override
    public UserDTO getTeacherById(int id) throws TException {
        return null;
    }

    @Override
    public UserDTO getUserByName(String username) throws TException {
        return null;
    }

    @Override
    public void regiserUser(UserDTO userInfo) throws TException {

    }
}
