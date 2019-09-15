package io.owuor91.controller;

import io.owuor91.models.Note;
import io.owuor91.repository.NoteRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotesController {
  @Autowired NoteRepository noteRepository;

  @GetMapping("/api/v1/notes")
  public List<Note> index() {
    return noteRepository.findAll();
  }

  @GetMapping("/api/v1/notes/{id}")
  public Note getNoteById(@PathVariable String id) {
    return noteRepository.findById(Integer.parseInt(id)).get();
  }

  @PostMapping("/api/v1/notes")
  public Note create(@RequestParam("title") String title,
      @RequestParam("note_text") String noteText) {
    return noteRepository.save(new Note(title, noteText));
  }

  @PutMapping("/api/v1/notes/{id}")
  public Note updateNote(@PathVariable String id, @RequestParam("title") String title,
      @RequestParam("note_text") String noteText) {
    Note note = noteRepository.findById(Integer.parseInt(id)).get();
    note.setTitle(title);
    note.setNoteText(noteText);
    return noteRepository.save(note);
  }

  @DeleteMapping("api/v1/notes/{id}")
  public Map<String, String> deleteNote(@PathVariable String id) {
    noteRepository.delete(noteRepository.findById(Integer.parseInt(id)).get());
    HashMap<String, String> deleteResp = new HashMap<String, String>();
    deleteResp.put("message", "note deleted successfully");
    return deleteResp;
  }
}
