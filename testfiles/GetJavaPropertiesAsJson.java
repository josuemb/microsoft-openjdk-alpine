package testfiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Get a predefined group of Java properties and in case you need it, you can
 * send more properties to be obtained as arguments.
 * It also replace dot character in property names to avoid any Json conflict.
 * By default it gets next Java properties:
 * - java.vendor
 * - java.version
 * - java.runtime.name
 * - java.runtime.version
 * - java.vm.name
 * - os.arch
 * - os.name
 * - os.version
 */
class GetJavaPropertiesAsJson {
    private static char SEPARATOR_ORIGINAL = '.';
    private static char SEPARATOR_REPLACEMENT = '_';
    private static String MAP_WRAPPER = "\"";
    private static String MAP_SEPARATOR = ":";
    private static String ELEMENTS_SEPARATOR = ",";
    private static String JSON_PREFIX = "{";
    private static String JSON_SUFFIX = "}";
    /**
     * Predefined list of properties to get.
     */
    private static String[] predefinedProperties = new String[] {
            "java.vendor",
            "java.version",
            "java.runtime.name",
            "java.runtime.version",
            "java.vm.name",
            "os.arch",
            "os.name",
            "os.version"
    };

    public static void main(String args[]) {
        var properties = new ArrayList<String>(predefinedProperties.length + args.length);
        properties.addAll(Arrays.asList(predefinedProperties));
        properties.addAll(Arrays.asList(args));
        var propertiesMap = GetProperties(properties);
        String jsonString = ToJsonString(propertiesMap);
        System.out.println(jsonString);
    }

    private static Map<String, String> GetProperties(Collection<String> propertyNames) {
        Map<String, String> propertiesMap = new HashMap<>();
        for (String propertyName : propertyNames) {
            var propertyValue = System.getProperty(propertyName);
            if (propertyValue != null) {
                propertyName = propertyName.replace(SEPARATOR_ORIGINAL, SEPARATOR_REPLACEMENT);
                propertiesMap.put(propertyName, propertyValue);
            }
        }
        return propertiesMap;
    }

    private static String ToJsonString(Map<String, String> map) {
        return map.entrySet()
                .stream()
                .map(entry -> (MAP_WRAPPER + entry.getKey() + MAP_WRAPPER
                        + MAP_SEPARATOR
                        + MAP_WRAPPER + entry.getValue() + MAP_WRAPPER))
                .collect(Collectors.joining(ELEMENTS_SEPARATOR, JSON_PREFIX, JSON_SUFFIX));
    }
}