package com.perfume.surfing.service;

import com.perfume.surfing.domain.Brand;
import com.perfume.surfing.domain.PerfumeNote;
import com.perfume.surfing.repository.PerfumeNoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class PerfumeNoteService {

    private final PerfumeNoteRepository perfumenoteRepository;


}
