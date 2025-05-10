package aiss.gitminer.util;

import io.github.cdimascio.dotenv.Dotenv;

public class Environment {
    private static final Dotenv dotenv = Dotenv.load();

    // GitMiner


    // GitHub
    public static final String GITHUB_TOKEN = dotenv.get("GITHUB_TOKEN");
    public static final String GITHUB_BASEURI = dotenv.get("GITHUB_BASEURI");

    public static final String GITHUB_DEFAULT_SINCE_COMMITS = DateUtils.getDateMinusDays(Integer.parseInt(dotenv.get("GITHUB_DEFAULT_SINCE_COMMITS")));
    public static final String GITHUB_DEFAULT_SINCE_ISSUES = DateUtils.getDateMinusDays(Integer.parseInt(dotenv.get("GITHUB_DEFAULT_SINCE_ISSUES")));
    public static final Integer GITHUB_DEFAULT_MAX_PAGES =Integer.valueOf(dotenv.get("GITHUB_DEFAULT_MAX_PAGES"));

    // Bitbucket
    public static final String BITBUCKET_USER = dotenv.get("BITBUCKET_USER");
    public static final String BITBUCKET_APP_PASSWORD = dotenv.get("BITBUCKET_APP_PASSWORD");
    public static final String BITBUCKET_BASEURI = dotenv.get("BITBUCKET_BASEURI");

    public static final String BITBUCKET_DEFAULT_SINCE_COMMITS = DateUtils.getDateMinusDays(Integer.parseInt(dotenv.get("GITHUB_DEFAULT_SINCE_COMMITS")));
    public static final String BITBUCKET_DEFAULT_SINCE_ISSUES = DateUtils.getDateMinusDays(Integer.parseInt(dotenv.get("GITHUB_DEFAULT_SINCE_ISSUES")));
    public static final Integer BITBUCKET_DEFAULT_MAX_PAGES =Integer.valueOf(dotenv.get("GITHUB_DEFAULT_MAX_PAGES"));
}
