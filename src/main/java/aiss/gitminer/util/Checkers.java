package aiss.gitminer.util;

import java.util.function.Predicate;

public class Checkers {
    /**
     * Check if the given token is a valid GitHub token.
     *
     * @param token the token to check
     * @return true if the token is a valid GitHub token, false otherwise
     */


    public static boolean isTokenGithub(String token) {
        Predicate<String> isTokenGithub = t -> t != null && t.startsWith("ghp_");
        return isTokenGithub.test(token);
    }
}
