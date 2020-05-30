package com.huy.ranking.model;

import java.util.ArrayList;

public class Contributor implements Comparable<Contributor> {
    private int id;
    private static int lastId = 1;
    private String name;
    private int post;
    private int comment;
    private int numberOfFeaturePost;
    private int bonusFromTopPost;
    private int point;
    private ArrayList<Integer> topFeaturePost;

    public Contributor(String name, double post, double comment, int numberOfFeaturePost, int bonusFromTopPost, ArrayList<Integer> topFeaturePost) {
        this.name = name;
        this.post = (int) post;
        this.comment = (int) comment;
        this.numberOfFeaturePost = numberOfFeaturePost;
        this.point = (int) Math.round((post * 26.4) + (comment * 1.25) + ((numberOfFeaturePost + bonusFromTopPost) * 57));
        this.topFeaturePost = new ArrayList<>(topFeaturePost);
    }

    public Contributor(String name, double post, double comment, int numberOfFeaturePost, int point, ArrayList<Integer> topFeaturePost, boolean haveId) {
        this.id = lastId++;
        this.name = name;
        this.post = (int) post;
        this.comment = (int) comment;
        this.numberOfFeaturePost = numberOfFeaturePost;
        this.point = point;
        this.topFeaturePost = new ArrayList<>(topFeaturePost);
    }

    public ArrayList<Integer> getTopFeaturePost() {
        return topFeaturePost;
    }

    public void resetId() {
        lastId = 1;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPost() {
        return post;
    }

    public void setPost(int post) {
        this.post = post;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    public int getNumberOfFeaturePost() {
        return numberOfFeaturePost;
    }

    public void setNumberOfFeaturePost(int numberOfFeaturePost) {
        this.numberOfFeaturePost = numberOfFeaturePost;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Contributor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", post=" + post +
                ", comment=" + comment +
                ", featurePost=" + numberOfFeaturePost +
                ", point=" + point +
                '}';
    }

    @Override
    public int compareTo(Contributor o) {
        return (o.point - this.point);
    }
}
