package edu.matc.persistence;

import edu.matc.entity.User;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created on 9/13/16.
 *
 * @author pwaite
 */
public class UserDaoTest {

    private final Logger logger = Logger.getLogger(this.getClass());
    UserDao dao;
    User user;


    int newUser = 0;

    @Before
    public void setup() {
        dao = new UserDao();


        user = new User();

        user.setFirstName("hallah");
        user.setLastName("hussien");
        user.setDateOfBirth(LocalDate.of(1995, 05, 14));
    }

    @Test
    public void getAllUsers() throws Exception {
        List<User> users = dao.getAllUsers();
        assertTrue(users.size() > 0);
    }

    @Test
    public void getUser() throws Exception {

    }

    @Test
    public void addUser() throws Exception {

            int id = dao.addUser(user);


            assertNotEquals(7, id);

            User insertedUser = dao.getUser(7);
            assertEquals(user.getFirstName(), insertedUser.getFirstName());
            assertEquals(user.getLastName(), insertedUser.getLastName());
            assertEquals(user.getDateOfBirth(), insertedUser.getDateOfBirth());
        }



    @Test
    public void deleteUser() throws Exception {
        dao.deleteUser(2);
        assertNull("User was not Deleted", dao.getUser(2));
    }

    @Test
    public void updateUser() throws Exception {

        User user = dao.getUser(1);
        dao.updateUser(user);

        User insertedUser = dao.getUser(1);
        assertEquals(user.getFirstName(), insertedUser.getFirstName());
        assertEquals(user.getLastName(), insertedUser.getLastName());
        assertEquals(user.getDateOfBirth(), insertedUser.getDateOfBirth());

    }

}