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

    @GetMapping(path = "")
    public String showRankingPage(Model model) {
        model.addAttribute("contributors", FinalListToUse.getHaiAnhPheCan().getContributors());
        model.addAttribute("posts", FinalListToUse.getHaiAnhPheCan().getPosts());
        model.addAttribute("interactPost", NumberFormat.getNumberInstance(Locale.US).format(FinalListToUse.getHaiAnhPheCan().getInteracts().get(0).getPost()));
        model.addAttribute("interactComment", NumberFormat.getNumberInstance(Locale.US).format(FinalListToUse.getHaiAnhPheCan().getInteracts().get(0).getComment()));
        model.addAttribute("interactReaction", NumberFormat.getNumberInstance(Locale.US).format(FinalListToUse.getHaiAnhPheCan().getInteracts().get(0).getReaction()));
        model.addAttribute("member", NumberFormat.getNumberInstance(Locale.US).format(FinalListToUse.getHaiAnhPheCan().getTotalMember()));
        return "index";
    }

//    @GetMapping(path = "/rank2")
//    public String showRankingPage2(Model model) {
//        model.addAttribute("contributors", FinalListToUse.getBackyardOfHeaven().getContributors());
//        model.addAttribute("posts", FinalListToUse.getBackyardOfHeaven().getPosts());
//        model.addAttribute("interactPost", NumberFormat.getNumberInstance(Locale.US).format(FinalListToUse.getBackyardOfHeaven().getInteracts().get(0).getPost()));
//        model.addAttribute("interactComment", NumberFormat.getNumberInstance(Locale.US).format(FinalListToUse.getBackyardOfHeaven().getInteracts().get(0).getComment()));
//        model.addAttribute("interactReaction", NumberFormat.getNumberInstance(Locale.US).format(FinalListToUse.getBackyardOfHeaven().getInteracts().get(0).getReaction()));
//        model.addAttribute("member", NumberFormat.getNumberInstance(Locale.US).format(FinalListToUse.getBackyardOfHeaven().getTotalMember()));
//        return "index2";
//    }
}
