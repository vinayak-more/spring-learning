package jpa.user;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spittr.config.PersistenceContext;
import com.spittr.config.RootConfig;
import com.spittr.web.bean.User;
import com.spittr.web.service.UserService;
import org.junit.Ignore;

/**
 * @author Vinayak More
 *
 * @date 17-Jul-2017
 */
@ContextConfiguration(classes = {RootConfig.class, PersistenceContext.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserTest {

    @Autowired
    UserService service;

    @Test
    public void shouldNotBeNull() {
        assertNotNull(service);
    }

    @Test
    public void getUserByUsername() {
        List<User> user = service.getUserByName("Vinayak");
        System.out.println("****************************");
        System.out.println(user);
        assertNotNull(user);
    }

    @Ignore
    @Test
    public void saveAndDeleteUser() {
        User user = new User();
        user.setName("Vinay");
        user.setAddress("Pune");
        user.setContactNumber("9988776655");
        User userEntity = service.save(user);
        System.out.println("***************");
        System.out.println("User entity = " + userEntity);
        service.delete(userEntity);
        assertNull(service.getUserById(userEntity.getId()));
    }

    @Ignore
    @Test
    public void saveUser() {
        User user = new User();
        user.setName("Vinayak More");
        user.setAddress("Pune");
        user.setContactNumber("9988776655");
        user.setSellerId(1L);
        User userEntity = service.save(user);
        System.out.println("***************");
        System.out.println("User entity = " + userEntity);
    }

}
