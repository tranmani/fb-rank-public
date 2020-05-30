package com.huy.ranking.controller;

import com.huy.ranking.model.Contributor;
import com.huy.ranking.model.Interact;
import com.huy.ranking.model.Post;

import java.util.ArrayList;
import java.util.List;

public class FinalListToUse {
    private List<Contributor> contributors;
    private List<Post> posts;
    private List<Interact> interacts;
    private double totalMember = 0;
    private static FinalListToUse haiAnhPheCan;
    private static FinalListToUse backyardOfHeaven;


    public FinalListToUse(List<Contributor> oldContributors, List<Post> oldPosts, List<Interact> oldInteracts, double oldTotalMember) {
        this.contributors = new ArrayList<>(oldContributors);
        this.posts = new ArrayList<>(oldPosts);
        this.interacts = new ArrayList<>(oldInteracts);
        this.totalMember = oldTotalMember;
    }

    public static void setBackyardOfHeaven(FinalListToUse backyardOfHeaven) {
        FinalListToUse.backyardOfHeaven = backyardOfHeaven;
    }

    public static void setHaiAnhPheCan(FinalListToUse haiAnhPheCan) {
        FinalListToUse.haiAnhPheCan = haiAnhPheCan;
    }

    public static FinalListToUse getHaiAnhPheCan() {
        return haiAnhPheCan;
    }

    public static FinalListToUse getBackyardOfHeaven() {
        return backyardOfHeaven;
    }

    public List<Contributor> getContributors() {
        return this.contributors;
    }

    public List<Post> getPosts() {
        return this.posts;
    }

    public List<Interact> getInteracts() {
        return this.interacts;
    }

    public double getTotalMember() {
        return this.totalMember;
    }
}
