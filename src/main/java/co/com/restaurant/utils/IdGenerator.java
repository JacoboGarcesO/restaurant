package co.com.restaurant.utils;

import java.util.UUID;

public class IdGenerator {
    public static String uuid() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
