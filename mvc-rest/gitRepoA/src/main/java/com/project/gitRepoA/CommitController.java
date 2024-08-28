package com.project.gitRepoA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@CrossOrigin
@Controller
public class CommitController {
    @Autowired
    CommitRepositoryImpl commits;

    Set<String> authorSet = new HashSet<>();

    RestTemplate template = new RestTemplate();
    private String baseAddress = "http://reader:8080";
    @RequestMapping("/")
    public String index(Model model) {
        List<String> headers = Arrays.asList("Time", "Commit", "Author", "Files", "In Lines", "Out Lines");
        Commit commit;
        Long amount = template.getForObject(baseAddress+ "/commits/amount", Long.class);
        for (int i = 1; i < amount; i++) {
            try {
                commit = template.getForObject(baseAddress + "/commits/" + i, Commit.class);
            }
            catch(NullPointerException e){
                String na = "Not Available";
                commit = new Commit(na,na,na,na,0,0);
            }
            authorSet.add(commit.getAuthor());
            commits.add(commit);
        }
        model.addAttribute("authornums", authorSet.size());
        model.addAttribute("headers",headers);
        model.addAttribute("Commit", commits.getAll());
        return "index";
    }
}
