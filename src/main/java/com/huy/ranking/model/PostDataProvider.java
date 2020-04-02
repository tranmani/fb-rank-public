package com.huy.ranking.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PostDataProvider {
    private static List<Post> posts = new ArrayList<>();
    private static List<Post> postsToBeSorted = new ArrayList<>();

    public static List<Post> getPosts() {
        return posts;
    }

    public static void addPostToBeSorted(Post post) {
        postsToBeSorted.add(post);
    }

    public static void addPost() {
        Collections.sort(postsToBeSorted);
        for (int i = 0; i < 50; i++) {
            posts.add(new Post(postsToBeSorted.get(i).getMember(), postsToBeSorted.get(i).getCaption(),
                    postsToBeSorted.get(i).getComment(), postsToBeSorted.get(i).getReaction(),
                    postsToBeSorted.get(i).getView(), postsToBeSorted.get(i).getLink(), true));
        }
    }
}
