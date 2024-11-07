package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    private Services Service;
    
    @GetMapping("/entercandidate")
    public String enterCandidate(@RequestParam String name) {
        if (Service.addCandidate(name)) {
            return "Candidate added: " + name;
        } else {
            return "Candidate already exists";
        }
    }

    @GetMapping("/castvote")
    public String castVote(@RequestParam String name) {
        try {
            int count = Service.castVote(name);
            return "Vote cast for " + name + ". Current vote count: " + count;
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    @GetMapping("/countvote")
    public String countVote(@RequestParam String name) {
        try {
            int count = Service.countVote(name);
            return "Vote count for " + name + ": " + count;
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    @GetMapping("/listvote")
    public Map<String, Integer> listVotes() {
        return Service.listVotes();
    }

    @GetMapping("/getwinner")
    public String getWinner() {
        return "Winner: " + Service.getWinner();
    }
}
