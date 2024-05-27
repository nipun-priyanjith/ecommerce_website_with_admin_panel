package model;
import java.util.HashMap;
import java.util.Map;
public class JavaDict {
    private Map<String, Object> data; // Use HashMap for efficient key-value storage

    public JavaDict() {
        this.data = new HashMap<>();
    }

    public void create(String key, Object value) {
        data.put(key, value);  // Add a new key-value pair
    }

    public Map<String, Object> readAll() {
        return Map.copyOf(data);  // Return a copy of the dictionary to avoid modification
    }

    public Object read(String key) {
        return data.get(key);  // Get the value for a specific key, return null if not found
    }

    public void delete(String key) {
        data.remove(key);  // Remove the key-value pair if it exists
    }
}
