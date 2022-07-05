package by.grsu.utils;

import java.util.UUID;

import static java.util.UUID.randomUUID;

/**
 * UUID utils
 */
public class UUIDUtils {

    /**
     * Method to generate UUID
     *
     * @return generated {@link UUID}
     */
    public static UUID generateUUID() {
        return randomUUID();
    }
}
