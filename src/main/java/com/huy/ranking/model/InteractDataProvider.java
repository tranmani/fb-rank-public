package com.huy.ranking.model;

import java.util.ArrayList;
import java.util.List;

public class InteractDataProvider {
    private static List<Interact> interactsToBeSum = new ArrayList<>();
    private static List<Interact> interacts = new ArrayList<>();

    public static List<Interact> getInteracts() {
        return interacts;
    }

    public static void addInteractionToBeSum(Interact interact) {
        interactsToBeSum.add(interact);
    }

    public static void sumAllInteract() {
        int post = 0;
        int comment = 0;
        int reaction = 0;
        for (int i = 0; i < interactsToBeSum.size(); i++) {
            post += interactsToBeSum.get(i).getPost();
            comment += interactsToBeSum.get(i).getComment();
            reaction += interactsToBeSum.get(i).getReaction();
        }

        interacts.add(new Interact(post, comment, reaction));
    }

}
