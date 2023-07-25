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
public class NoteService {

    private final NoteRepository noteRepository;

    @Transactional
    public int add(Note note){
        validateDuplicateNote(note);  // 중복 검사
        noteRepository.save(note);
        return note.getId();
    }

    private  void validateDuplicateNote(Note note){
        noteRepository.findByName(note.getName())
                .ifPresent(m->{
                    throw new IllegalStateException("이미 존재하는 노트입니다.");
                });
    }

    public List<Note> findNotes(){
        return noteRepository.findAll();
    }

    public Optional<Note> findOne(int noteId){
        return noteRepository.findById(noteId);
    }

}
