package com.wesley.user.controller;

import com.wesley.thrift.user.UserDTO;
import com.wesley.user.domain.vo.UserVO;
import com.wesley.user.support.ThriftClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @author Created by Yani on 2019/12/02
 */
@RestController
@Slf4j
public class UserController {

    @Autowired
    ThriftClient thriftClient;

    @GetMapping("/users/{id}")
    public UserVO getUserById(@PathVariable String id) {
        UserVO result = new UserVO();
        try {
            thriftClient.open();
            UserDTO userDto = thriftClient.getUserServiceClient().getUserById(1);
            BeanUtils.copyProperties(userDto, result);
        } catch (TException e) {
            e.printStackTrace();
        } finally {
            thriftClient.close();
        }
        return result;
    }
}
