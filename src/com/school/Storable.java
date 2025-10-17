package com.school;

/**
 * Simple interface indicating an object can be converted to a storable string.
 */
public interface Storable {
    /**
     * Convert the object into a string suitable for storage (e.g., CSV line).
     */
    String toDataString();
}
