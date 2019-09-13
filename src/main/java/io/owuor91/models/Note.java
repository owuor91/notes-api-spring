package io.owuor91.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name = "notes") public class Note {
  @Id @GeneratedValue(strategy = GenerationType.AUTO) private int id;
  private String title;
  @Column(name = "note_text") private String noteText;

  public Note(String title, String noteText) {
    this.title = title;
    this.noteText = noteText;
  }

  public Note() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getNoteText() {
    return noteText;
  }

  public void setNoteText(String noteText) {
    this.noteText = noteText;
  }
}
