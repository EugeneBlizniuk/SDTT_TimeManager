package by.bsuir.manager.dao.secure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordSecureTest {

    @Test
    void getPasswordHash() {
        String password_1 = "123";
        String password_2 = "123";
        int hashedPassword1 = PasswordSecure.getInstance().getPasswordHash(password_1);
        int hashedPassword2 = PasswordSecure.getInstance().getPasswordHash(password_2);
        assertEquals(hashedPassword1, hashedPassword2);
    }
}