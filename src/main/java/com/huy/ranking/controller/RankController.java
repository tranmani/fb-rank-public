package com.huy.ranking.controller;

import com.huy.ranking.model.ContributorDataProvider;
import com.huy.ranking.ExcelReader;
import com.huy.ranking.model.InteractDataProvider;
import com.huy.ranking.model.PostDataProvider;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.text.NumberFormat;
import java.util.Locale;

@Controller
@RequestMapping(path = "/")
public class RankController {
//    public static void main(String[] args) {
//        FacebookClient facebookClient = new DefaultFacebookClient(Constant.MY_ACCESS_TOKEN, Version.LATEST);
//
//        User user = facebookClient.fetchObject("me/groups", User.class);
//
//        System.out.println(user);
//    }

    @GetMapping(path = "")
    public String showRankingPage(Model model) {
        model.addAttribute("contributors", ContributorDataProvider.getContributor());
        model.addAttribute("posts", PostDataProvider.getPosts());
        model.addAttribute("interactPost", NumberFormat.getNumberInstance(Locale.US).format(InteractDataProvider.getInteracts().get(0).getPost()));
        model.addAttribute("interactComment", NumberFormat.getNumberInstance(Locale.US).format(InteractDataProvider.getInteracts().get(0).getComment()));
        model.addAttribute("interactReaction", NumberFormat.getNumberInstance(Locale.US).format(InteractDataProvider.getInteracts().get(0).getReaction()));
        model.addAttribute("member", NumberFormat.getNumberInstance(Locale.US).format(ExcelReader.getMember()));
        return "index";
    }

    @GetMapping(path = "login")
    public String showLoginPage(Model model) {
//        FacebookClient facebookClient = new DefaultFacebookClient(Constant.MY_ACCESS_TOKEN, Version.LATEST);
//
//        User user = facebookClient.fetchObject("me", User.class);
//
//        model.addAttribute("name", user.getName());
//        System.out.println(user);
        return "login";
    }

    @GetMapping(path = "insight")
    public String newestInsight(Model model) {
        model.addAttribute("insight", ExcelReader.FILE_NAME);
        return "insight";
    }
}
