import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class NameObfuscator {
    private static final String CHARSET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_";
    private static final Random RANDOM = new Random();
    private static final Set<String> usedNames = new HashSet<>();
    private static final HashMap<String, String> nameMap = new HashMap<>();

    public static String generateUniqueRandomString() {
        int length = 12 + RANDOM.nextInt(14);
        String randomStr;
        do {
            randomStr = generateRandomString(length);
        } while (usedNames.contains(randomStr));

        usedNames.add(randomStr);
        return randomStr;
    }

    private static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);

        int firstCharIndex = RANDOM.nextInt(53);
        sb.append(CHARSET.charAt(firstCharIndex));

        for (int i = 1; i < length; i++) {
            int index = RANDOM.nextInt(CHARSET.length());
            sb.append(CHARSET.charAt(index));
        }

        return sb.toString();
    }

    public static String obfuscateVariableName(String originalName) {
        if (nameMap.containsKey(originalName)) {
            return nameMap.get(originalName);
        }

        String obfuscatedName = generateUniqueRandomString();
        nameMap.put(originalName, obfuscatedName);
        return obfuscatedName;
    }
}
