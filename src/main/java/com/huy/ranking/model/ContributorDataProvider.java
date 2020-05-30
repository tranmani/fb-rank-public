package com.huy.ranking.model;

import java.util.*;

public class ContributorDataProvider {
    private static List<Contributor> contributors = new ArrayList<>();
    private static List<Contributor> contributorsToBeSorted = new ArrayList<>();

    public static List<Contributor> getContributor() {
        return contributors;
    }

    public static void addContributorsToBeSort(String name, double post, double comment) {
        contributorsToBeSorted.add(new Contributor(name, post, comment, countNumberOfFeaturePost(name), countBonusFromTopPost(name), countFeaturePost(name)));
    }

    public static void addContributor() {
        Collections.sort(contributorsToBeSorted);
        for (int i = 0; i < 50; i++) {
            contributors.add(new Contributor(contributorsToBeSorted.get(i).getName(), contributorsToBeSorted.get(i).getPost(), contributorsToBeSorted.get(i).getComment(), contributorsToBeSorted.get(i).getNumberOfFeaturePost(), contributorsToBeSorted.get(i).getPoint(), contributorsToBeSorted.get(i).getTopFeaturePost(),true));
            if (contributors.get(i).getId() == 50) {
                contributors.get(i).resetId();
            }
        }
    }

    public static int countNumberOfFeaturePost(String name) {
        int featurePostNr = 0;
        for (int i = 0; i < PostDataProvider.getPosts().size(); i++) {
            if (name.equals(PostDataProvider.getPosts().get(i).getMember())) {
                featurePostNr++;
            }
        }
        return featurePostNr;
    }

    public static ArrayList<Integer> countFeaturePost(String name) {
        ArrayList<Integer> topFeaturePostNr = new ArrayList<>();
        for (int i = 0; i < PostDataProvider.getPosts().size(); i++) {
            if (name.equals(PostDataProvider.getPosts().get(i).getMember())) {
                topFeaturePostNr.add(PostDataProvider.getPosts().get(i).getId());
            }
        }
        return topFeaturePostNr;
    }

    public static int countBonusFromTopPost(String name) {
        int bonusFromTopPost = 0;
        for (int i = 0; i < PostDataProvider.getPosts().size(); i++) {
            if (name.equals(PostDataProvider.getPosts().get(i).getMember())) {
                if (PostDataProvider.getPosts().get(i).getId() == 1) {
                    bonusFromTopPost += 2.5;
                }
                if (PostDataProvider.getPosts().get(i).getId() == 2) {
                    bonusFromTopPost += 2;
                }
                if (PostDataProvider.getPosts().get(i).getId() == 3) {
                    bonusFromTopPost += 1.5;
                }
                if (PostDataProvider.getPosts().get(i).getId() == 4) {
                    bonusFromTopPost += 1;
                }
                if (PostDataProvider.getPosts().get(i).getId() == 5) {
                    bonusFromTopPost += 0.5;
                }
            }
        }
        return bonusFromTopPost;
    }

    public static void clearList() {
        contributors.clear();
        contributorsToBeSorted.clear();
    }
}
