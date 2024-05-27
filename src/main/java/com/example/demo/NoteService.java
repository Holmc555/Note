package com.example.demo;

import com.example.demo.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    public List<NoteCont> getAllNotes() {
        return noteRepository.findAll();
    }

    public Optional<NoteCont> getNoteById(Long id) {
        return noteRepository.findById(id);
    }

    public NoteCont createNote(NoteCont note) {
        return noteRepository.save(note);
    }

    public NoteCont updateNote(Long id, NoteCont noteDetails) {
        NoteCont note = noteRepository.findById(id).orElseThrow(() -> new RuntimeException("Note not found"));

        note.setTitle(noteDetails.getTitle());
        note.setContent(noteDetails.getContent());

        return noteRepository.save(note);
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }
}
