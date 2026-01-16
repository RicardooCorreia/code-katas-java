package code.wars.brute_force_detector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class BruteForceDetector {

    public static List<String> detectBruteForce(String[] logs) {

        Map<String, Integer> failCounts = new HashMap<>();
        TreeSet<String> suspiciousIps = new TreeSet<>();
        for (String log : logs) {
            LoginAttempt attempt = parseLog(log);
            if (attempt.success()) {
                failCounts.put(attempt.ip(), 0);
            } else {
                int currentFails = failCounts.getOrDefault(attempt.ip(), 0) + 1;
                if (currentFails == 3) {
                   suspiciousIps.add(attempt.ip());
                }
                failCounts.put(attempt.ip(), currentFails);
            }

        }
        return suspiciousIps.stream().toList();
    }

    private static LoginAttempt parseLog(String log) {

        String[] parts = log.split(" ");
        return new LoginAttempt(parts[0], parts[2], "LOGIN_SUCCESS".equals(parts[1]));
    }

    public record LoginAttempt(String ip, String user, boolean success) {
    }
}
