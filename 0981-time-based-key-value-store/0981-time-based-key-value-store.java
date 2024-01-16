import java.util.HashMap;
import java.util.TreeMap;

class TimeMap {
    private final HashMap<String, TreeMap<Integer, String>> timeMapInternal;

    public TimeMap() {
        timeMapInternal = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        timeMapInternal
                .computeIfAbsent(key, k -> new TreeMap<>())
                .put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> innerMap = timeMapInternal.get(key);

        if (innerMap == null) {
            return "";
        }

        Integer floorTimestamp = innerMap.floorKey(timestamp);

        return floorTimestamp != null ? innerMap.get(floorTimestamp) : "";
    }
}
