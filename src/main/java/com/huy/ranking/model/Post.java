package com.huy.ranking.model;

public class Post implements Comparable<Post> {
    private int id;
    private static int lastId = 1;
    private String member;
    private String caption;
    private int comment;
    private int reaction;
    private int view;
    private String link;
    private int point;

    public Post(String member, String caption, double comment, double reaction, double view, String link) {
        this.member = member;
        this.caption = caption;
        this.comment = (int) comment;
        this.reaction = (int) reaction;
        this.view = (int) view;
        this.link = link;
        this.point = (int) (comment + reaction + view);
    }

    public Post(String member, String caption, double comment, double reaction, double view, String link, boolean haveId) {
        this.id = lastId++;
        this.member = member;
        this.caption = caption;
        this.comment = (int) comment;
        this.reaction = (int) reaction;
        this.view = (int) view;
        this.link = link;
        this.point = (int) (comment + reaction + view);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    public int getReaction() {
        return reaction;
    }

    public void setReaction(int reaction) {
        this.reaction = reaction;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", member='" + member + '\'' +
                ", caption='" + caption + '\'' +
                ", comment=" + comment +
                ", reaction=" + reaction +
                ", view=" + view +
                ", link='" + link + '\'' +
                '}';
    }

    @Override
    public int compareTo(Post o) {
//        return ((o.comment + o.reaction + o.view) - (this.comment + this.reaction + o.view));
        return (o.point - this.point);
    }
}
