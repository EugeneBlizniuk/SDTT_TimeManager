package by.bsuir.manager.dao.secure;

import org.bouncycastle.crypto.digests.SHA256Digest;

public final class PasswordSecure {
    private static final PasswordSecure INSTANCE = new PasswordSecure();
    private static SHA256Digest m_SHA256;

    static {
        m_SHA256 = new SHA256Digest();
    }

    private PasswordSecure() {}

    public static PasswordSecure getInstance() {
        return INSTANCE;
    }

    private int countHashedPassword(byte[] hashedPassword) {
        int result = 0;
        for(int i = hashedPassword.length; i > 0; --i) {
            if(hashedPassword[i-1] > 0) {
                result += hashedPassword[i-1];
            }
        }
        return result;
    }

    public final int getPasswordHash(String password) {

        byte[] message = password.getBytes();
        m_SHA256.reset();
        m_SHA256.update(message, 0, message.length);
        byte[] hashedPassword = new byte[m_SHA256.getDigestSize()];
        m_SHA256.doFinal(hashedPassword, 0);

        return countHashedPassword(hashedPassword);
    }
}
