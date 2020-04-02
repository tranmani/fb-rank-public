package com.huy.ranking.model;

import java.util.*;

public class ContributorDataProvider {
    private static List<Contributor> contributors = new ArrayList<>();
    private static List<Contributor> contributorsToBeSorted = new ArrayList<>();

    public static List<Contributor> getContributor() {
        return contributors;
    }

    public static void addContributorsToBeSort(String name, double post, double comment) {
        contributorsToBeSorted.add(new Contributor(name, post, comment, countFeaturePost(name)));
    }

    public static void addContributor() {
        Collections.sort(contributorsToBeSorted);
        for (int i = 0; i < 50; i++) {
            contributors.add(new Contributor(contributorsToBeSorted.get(i).getName(), contributorsToBeSorted.get(i).getPost(), contributorsToBeSorted.get(i).getComment(), contributorsToBeSorted.get(i).getFeaturePost(),true));
        }
    }

    public static int countFeaturePost(String name) {
        int featurePostNr = 0;
        for (int i = 0; i < PostDataProvider.getPosts().size(); i++) {
            if (name.equals(PostDataProvider.getPosts().get(i).getMember())) {
                featurePostNr++;
            }
        }
        return featurePostNr;
    }
}
