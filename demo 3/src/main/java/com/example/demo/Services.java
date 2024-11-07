package com.example.demo;
import org.springframework.stereotype.Service;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class Services {
    private final ConcurrentHashMap<String, AtomicInteger> candidates = new ConcurrentHashMap<>();

    public boolean addCandidate(String name) {
        return candidates.putIfAbsent(name, new AtomicInteger(0)) == null;
    }

    public int castVote(String name) {
        AtomicInteger voteCount = candidates.get(name);
        if (voteCount == null) throw new IllegalArgumentException("Invalid candidate");
        return voteCount.incrementAndGet();
    }

    public int countVote(String name) {
        AtomicInteger voteCount = candidates.get(name);
        if (voteCount == null) throw new IllegalArgumentException("Invalid candidate");
        return voteCount.get();
    }

    public Map<String, Integer> listVotes() {
        return candidates.entrySet().stream().collect(
            Collectors.toMap(Map.Entry::getKey, e -> e.getValue().get()));
    }

    public String getWinner() {
        return candidates.entrySet().stream()
                .max(Comparator.comparingInt(e -> e.getValue().get()))
                .map(Map.Entry::getKey)
                .orElse("No candidates found");
    }
}
