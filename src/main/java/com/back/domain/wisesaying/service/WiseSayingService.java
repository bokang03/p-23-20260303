package com.back.domain.wisesaying.service;

import com.back.domain.wisesaying.entity.WiseSaying;
import com.back.domain.wisesaying.repository.WiseSayingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WiseSayingService {

    private final WiseSayingRepository wiseSayingRepository;

    public WiseSaying write(String content, String author) {

        WiseSaying wiseSaying = new WiseSaying(content, author);
        wiseSayingRepository.save(wiseSaying);

        return wiseSaying;
    }

    public List<WiseSaying> findAll() {
        return wiseSayingRepository.findAll();
    }

    public WiseSaying findById(int id) {
        Optional<WiseSaying> wiseSaying = wiseSayingRepository.findById(id);

        if(wiseSaying.isEmpty()) {
            throw new RuntimeException("%d번 명언은 존재하지 않습니다.".formatted(id));
        }

        return wiseSaying.get();
    }

    public void delete(WiseSaying wiseSaying) {
        wiseSayingRepository.delete(wiseSaying);
    }

    public void modify(WiseSaying wiseSaying, String content, String author) {
        wiseSaying.update(content, author);
        wiseSayingRepository.save(wiseSaying);
    }
}