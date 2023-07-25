package com.perfume.surfing.service;

import com.perfume.surfing.domain.*;
import com.perfume.surfing.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PerfumeService {

    private final PerfumeRepository perfumeRepository;

    public int add(Perfume perfume){
        validateDuplicatePerfume(perfume);  // 중복 검사
        perfumeRepository.save(perfume);
        return perfume.getId();
    }

    private void validateDuplicatePerfume(Perfume brand) {
        perfumeRepository.findByName(brand.getName())
                .ifPresent(m->{
                    throw new IllegalStateException("이미 존재하는 향수입니다.");
                });
    }

    public List<Perfume> findPerfumes(){
        return perfumeRepository.findAll();
    }

    public Optional<Perfume> findPerfumeOne(int perfumeId){
        return perfumeRepository.findById(perfumeId);
    }
}

