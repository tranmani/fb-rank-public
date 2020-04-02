package com.huy.ranking.model;

public class Interact {
    private int post;
    private int comment;
    private int reaction;

    public Interact(double post, double comment, double reaction) {
        this.post = (int) post;
        this.comment = (int) comment;
        this.reaction = (int) reaction;
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

    public int getReaction() {
        return reaction;
    }

    public void setReaction(int reaction) {
        this.reaction = reaction;
    }
}
