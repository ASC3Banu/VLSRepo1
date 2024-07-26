package org;



import com.learning.model.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    private User user;
    @Before
    public void setUp() {
        user = new User("testUser", "testPassword");
    }

    @Test
    public void testUserConstructorAndGetters() {
        assertEquals("testUser", user.getLoginId());
        assertEquals("testPassword", user.getPassword());
    }

    @Test
    public void testUserSetters() {
        user.setId(1);
        user.setLoginId("anotherUser");
        user.setPassword("anotherPassword");

        assertEquals(1, user.getId());
        assertEquals("anotherUser", user.getLoginId());
        assertEquals("anotherPassword", user.getPassword());
    }

    @Test
    public void testUserToString() {
        user.setId(2);
        String expected = "User{id=2, loginId='testUser', password='testPassword'}";
        assertEquals(expected, user.toString());
    }

    @Test
    public void testNotEquals() {
        User user1 = new User("user1", "password1");
        user1.setId(1);

        User user2 = new User("user2", "password2");
        user2.setId(2);

        assertFalse(user1.equals(user2));
        assertNotEquals(user1.hashCode(), user2.hashCode());
    }
}

