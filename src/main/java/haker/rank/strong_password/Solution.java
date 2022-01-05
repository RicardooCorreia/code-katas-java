package haker.rank.strong_password;

import java.io.*;
import java.util.regex.Pattern;

class Result {

    public static final int PASSWORD_MINIMUM_LENGTH = 6;
    public static final Pattern LOWER_CASE_PATTERN = Pattern.compile("[a-z]");
    public static final Pattern UPPER_CASE_PATTERN = Pattern.compile("[A-Z]");
    public static final Pattern NUMBER_PATTERN = Pattern.compile("[0-9]");
    public static final Pattern SPECIAL_CHARACTER_PATTERN = Pattern.compile("[^A-Za-z0-9]");
    public static final int MAX_PATTERN_MISSING = 4;

    public static int minimumNumber(int n, String password) {

        final int charactersToMinimumLength = charactersToMinimumLength(password);
        if (charactersToMinimumLength >= MAX_PATTERN_MISSING) {
            return charactersToMinimumLength;
        }

        final int missingChars = getMissingChars(password);
        return Math.max(missingChars, charactersToMinimumLength);
    }

    private static int getMissingChars(String password) {

        final boolean hasLowerCase = matches(LOWER_CASE_PATTERN, password);
        final boolean hasUpperCase = matches(UPPER_CASE_PATTERN, password);
        final boolean hasNumber = matches(NUMBER_PATTERN, password);
        final boolean hasSpecialChar = matches(SPECIAL_CHARACTER_PATTERN, password);

        int missingChars = 0;
        if (!hasLowerCase) {
            missingChars++;
        }
        if (!hasUpperCase) {
            missingChars++;
        }
        if (!hasNumber) {
            missingChars++;
        }
        if (!hasSpecialChar) {
            missingChars++;
        }
        return missingChars;
    }

    private static boolean matches(Pattern pattern, String password) {

        return pattern.matcher(password).find();
    }

    private static int charactersToMinimumLength(String password) {

        return Math.max(PASSWORD_MINIMUM_LENGTH - password.length(), 0);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String password = bufferedReader.readLine();

        int answer = Result.minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

