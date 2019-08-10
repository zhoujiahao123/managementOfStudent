package service.impl;

import entity.Users;
import org.junit.Assert;
import org.junit.Test;
import service.UsersDao;

public class TestUsersDaoImpl {
    @Test
    public void testUsersLogin(){
        Users users = new Users(1,"小周","123");
        UsersDao usersDao = new UsersDaoImpl();
        Assert.assertEquals(true,usersDao.usersLogin(users));
    }
}
