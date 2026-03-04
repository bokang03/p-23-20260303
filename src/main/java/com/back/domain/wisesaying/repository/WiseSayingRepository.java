package com.back.domain.wisesaying.repository;

import com.back.domain.wisesaying.entity.WiseSaying;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WiseSayingRepository extends JpaRepository<WiseSaying, Integer> {

}
