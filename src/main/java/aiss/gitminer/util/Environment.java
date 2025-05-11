package aiss.gitminer.util;

import io.github.cdimascio.dotenv.Dotenv;

public class Environment {
    private static final Dotenv dotenv = Dotenv.load();

    // GitHub
    public static final String GITHUB_TOKEN = dotenv.get("GITHUB_TOKEN");
    public static final String GITHUB_BASEURI = dotenv.get("GITHUB_BASEURI");

    public static final String GITHUB_DEFAULT_SINCE_COMMITS = Utils.getDateMinusDays(Integer.parseInt(dotenv.get("GITHUB_DEFAULT_SINCE_COMMITS")));
    public static final String GITHUB_DEFAULT_SINCE_ISSUES = Utils.getDateMinusDays(Integer.parseInt(dotenv.get("GITHUB_DEFAULT_SINCE_ISSUES")));
    public static final Integer GITHUB_DEFAULT_MAX_PAGES =Integer.valueOf(dotenv.get("GITHUB_DEFAULT_MAX_PAGES"));

    // Bitbucket
    public static final String BITBUCKET_BASEURI = dotenv.get("BITBUCKET_BASEURI");

    public static final Integer BITBUCKET_DEFAULT_NCOMMITS = Integer.valueOf(dotenv.get("BITBUCKET_DEFAULT_NCOMMITS"));
    public static final Integer BITBUCKET_DEFAULT_NISSUES = Integer.valueOf(dotenv.get("BITBUCKET_DEFAULT_NISSUES"));
    public static final Integer BITBUCKET_DEFAULT_MAX_PAGES =Integer.valueOf(dotenv.get("BITBUCKET_DEFAULT_MAX_PAGES"));
}
