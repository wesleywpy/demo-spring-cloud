package com.wesley.thrift.user.service;

import com.wesley.thrift.user.UserDTO;
import com.wesley.thrift.user.UserService;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * </p>
 *
 * @author Created by Yani on 2019/11/27
 */
@Service
public class UserServiceImpl implements UserService.Iface {

    @Override
    public UserDTO getUserById(int id) throws TException {
        UserDTO result = new UserDTO();
        result.setUsername("Wesley");
        result.setId(id);
        result.setEmail("yani@uoko.com");
        return result;
    }

    @Override
    public UserDTO getTeacherById(int id) throws TException {
        return new UserDTO();
    }

    @Override
    public UserDTO getUserByName(String username) throws TException {
        UserDTO result = new UserDTO();
        result.setUsername(username);
        result.setEmail("yani@uoko.com");
        result.setMobile("15100001111");
        return result;
    }

    @Override
    public void regiserUser(UserDTO userInfo) throws TException {

    }
}
