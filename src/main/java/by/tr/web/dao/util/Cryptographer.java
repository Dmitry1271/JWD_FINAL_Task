package by.tr.web.dao.util;

import by.tr.web.entity.Role;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by cplus on 23.11.2017.
 */
public final class Cryptographer {
    private static final String ALGORITHM = "MD5";
    private static final String ENCODING = "UTF-8";
    private static final String FORMAT = "%02x";
    private static final int SALT_BYTES_SIZE = 16;
    private static final int TOKEN_BYTES_SIZE = 16;
    private static final int SIGNUM = 1;
    private static final char DELIMITER = ':';


    private Cryptographer() {
    }

    public static String getEncryptPassword(String password, String salt) throws NoSuchAlgorithmException {
        String saltedPassword = password + salt;

        MessageDigest md5 = MessageDigest.getInstance(ALGORITHM);
        md5.update(saltedPassword.getBytes(Charset.forName(ENCODING)));
        byte[] bytes = md5.digest();

        return String.format(FORMAT, new BigInteger(SIGNUM, bytes));
    }

    public static String generateSalt() {
        return generateRandomString(SALT_BYTES_SIZE);
    }

    public static String generateAccessToken(int id, Role role) {
        return String.valueOf(id) + DELIMITER + role + DELIMITER + generateRandomString(TOKEN_BYTES_SIZE);
    }

    public static String generateRefreshToken() {
        return generateRandomString(TOKEN_BYTES_SIZE);
    }

    private static String generateRandomString(int size) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bytes = new byte[size];
        secureRandom.nextBytes(bytes);

        return String.format(FORMAT, new BigInteger(SIGNUM, bytes));
    }
}
