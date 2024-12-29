package com.edwin.usercenter.service;
import com.edwin.usercenter.exception.BusinessException;
import com.edwin.usercenter.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * 用户服务测试
 */
@SpringBootTest
public class UserServiceTest {

    @Resource
    private UserService userService;

    /**
     * 测试添加用户
     */
    @Test
    public void testAddUser() {
        User user = new User();
        user.setUsername("dogYupi");
        user.setUserAccount("123");
        user.setAvatarUrl("https://636f-codenav-8grj8px727565176-1256524210.tcb.qcloud.la/img/logo.png");
        user.setGender(0);
        user.setUserPassword("xxx");
        user.setPhone("123");
        user.setEmail("456");
        boolean result = userService.save(user);
        System.out.println(user.getId());
        Assertions.assertTrue(result);
    }

    // https://www.code-nav.cn/

    /**
     * 测试更新用户
     */
    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setId(1L);
        user.setUsername("dogYupi");
        user.setUserAccount("123");
        user.setAvatarUrl("https://636f-codenav-8grj8px727565176-1256524210.tcb.qcloud.la/img/logo.png");
        user.setGender(0);
        user.setUserPassword("xxx");
        user.setPhone("123");
        user.setEmail("456");
        boolean result = userService.updateById(user);
        Assertions.assertTrue(result);
    }

    /**
     * 测试删除用户
     */
    @Test
    public void testDeleteUser() {
        boolean result = userService.removeById(1L);
        Assertions.assertTrue(result);
    }

    /**
     * 测试获取用户
     */
    @Test
    public void testGetUser() {
        User user = userService.getById(1L);
        Assertions.assertNotNull(user);
    }

    /**
     * 测试用户注册
     */
    @Test
    void userRegister() {
        // 参数符合要求的场景
        String userAccount = "yupi2";
        String userPassword = "12345678";
        String checkPassword = "12345678";
        String planetCode = "2";

        long result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertTrue(result > 0); // 确保返回有效用户ID

        // 用户名过短
        Assertions.assertThrows(BusinessException.class, () -> {
            userService.userRegister("yu", userPassword, checkPassword, planetCode);
        });

        // 密码长度不足
        Assertions.assertThrows(BusinessException.class, () -> {
            userService.userRegister(userAccount, "12345", "12345", planetCode);
        });

        // 密码与确认密码不一致
        Assertions.assertEquals(-1, userService.userRegister(userAccount, userPassword, "87654321", planetCode));

        // 用户名包含非法字符
        Assertions.assertEquals(-1, userService.userRegister("yupi@", userPassword, checkPassword, planetCode));


        //String userAccount = "yupi";
        //String userPassword = "123456";
        //String checkPassword = "123456";
        //String planetCode = "1";
        //long result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        //Assertions.assertEquals(-1, result);
        //userAccount = "yu";
        //result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        //Assertions.assertEquals(-1, result);
        //userAccount = "yupi";
        //userPassword = "123456";
        //result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        //Assertions.assertEquals(-1, result);
        //userAccount = "yu pi";
        //userPassword = "12345678";
        //result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        //Assertions.assertEquals(-1, result);
        //checkPassword = "123456789";
        //result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        //Assertions.assertEquals(-1, result);
        //userAccount = "dogYupi";
        //checkPassword = "12345678";
        //result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        //Assertions.assertEquals(-1, result);
        //userAccount = "yupi";
        //result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        //Assertions.assertEquals(-1, result);
    }
}