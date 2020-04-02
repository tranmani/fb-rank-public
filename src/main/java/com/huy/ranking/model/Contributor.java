package com.huy.ranking.model;

public class Contributor implements Comparable<Contributor> {
    private int id;
    private static int lastId = 1;
    private String name;
    private int post;
    private int comment;
    private int featurePost;
    private int point;

    public Contributor(String name, double post, double comment, int featurePost) {
        this.name = name;
        this.post = (int) post;
        this.comment = (int) comment;
        this.featurePost = featurePost;
        this.point = (int) Math.round((post * 26.4) + (comment * 1.25)) + (featurePost * 57);
}

    public Contributor(String name, double post, double comment, int featurePost, boolean haveId) {
        this.id = lastId++;
        this.name = name;
        this.post = (int) post;;
        this.comment = (int) comment;
        this.featurePost = featurePost;
        this.point = (int) ((int) (post * 26.4) + (comment * 1.25)) + (featurePost * 57);
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

    public int getFeaturePost() {
        return featurePost;
    }

    public void setFeaturePost(int featurePost) {
        this.featurePost = featurePost;
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
                ", featurePost=" + featurePost +
                ", point=" + point +
                '}';
    }

    @Override
    public int compareTo(Contributor o) {
        return (o.point - this.point);
    }
}
