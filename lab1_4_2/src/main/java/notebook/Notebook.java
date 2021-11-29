package notebook;

import com.google.gson.Gson;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Notebook {
    private String df = "yyyy-MM-dd kk:mm:ss";

    public class Note implements Comparable {
        private String title;
        private String text;
        private Date date;

        public Note(String title, String text) {
            this.title = title;
            this.text = text;
            this.date = new Date();
        }

        private Note() {
        }

        public Date noteDate() {
            return date;
        }

        public String noteText() {
            return text;
        }

        public String noteTitle() {
            return title;
        }

        @Override
        public int compareTo(Object o) {
            Note a = (Note) o;
            return (noteDate().compareTo(a.noteDate()));
        }
    }

    private Gson gson = new Gson();
    private String name;

    public Notebook(String str) {
        this.name = str;
    }

    public ArrayList<Note> readNotes() {
        try {
            Reader r = new FileReader(name);
            Note[] notearr = gson.fromJson(r, Note[].class);
            ArrayList<Note> notelist = new ArrayList<>(Arrays.asList(notearr));
            return notelist;
        } catch (FileNotFoundException e) {
            return new ArrayList<Note>();
        }
    }

    private void writeNotes(ArrayList<Note> val) {
        try (Writer w = new FileWriter(name)) {
            gson.toJson(val, w);
        } catch (IOException e) {
            System.err.println("Notes weren't saved:" + e.getMessage());
        }
    }

    public void addNote(String tit, String txt) {
        Note note = new Note(tit, txt);
        ArrayList<Note> book = readNotes();
        book.add(note);
        writeNotes(book);
    }

    public void removeNote(String title) {
        ArrayList<Note> notelist = readNotes();

        if (notelist.removeIf(Note -> Note.noteTitle().equals(title)))
            writeNotes(notelist);
        else
            System.err.println("Failed to delete note with title:" + title);
    }

    private void printNote(Note note, DateFormat a) {

        System.out.println(a.format(note.noteDate()));
        System.out.println(note.noteTitle());
        System.out.println(note.noteText());
    }

    public void printBook() {
        Reader r = null;
        try {
            r = new FileReader(name);
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
        Note[] notearr = gson.fromJson(r, Note[].class);
        Arrays.sort(notearr);
        DateFormat dateFormat = new SimpleDateFormat(df);
        for (Note note : notearr) printNote(note, dateFormat);
    }

    public void printBook(Date beg, Date end, String[] keyWs) {
        DateFormat dateFormat = new SimpleDateFormat(df);
        Reader r = null;
        try {
            r = new FileReader(name);
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
        Note[] notearr = gson.fromJson(r, Note[].class);
        Arrays.sort(notearr);
        int i = 0;
        int b, e;

        try {
            for (i = 0; notearr[i].noteDate().compareTo(beg) <= 0; i++) ;
        } catch (IndexOutOfBoundsException a) {
            i = notearr.length;
        }
        b = i;
        if (i == notearr.length) return;
        try {
            for (i = i; notearr[i].noteDate().compareTo(end) <= 0; i++) ;
        } catch (IndexOutOfBoundsException a) {
            i = notearr.length;
        }

        e = i;
        notearr = Arrays.copyOfRange(notearr, b, e);
        if (keyWs.length == 0)
            for (Note note : notearr) printNote(note, dateFormat);
        else {
            for (Note note : notearr) {
                for (String str : keyWs) {
                    if (note.noteTitle().contains(str)) {
                        printNote(note, dateFormat);
                        continue;
                    }
                }

            }
        }

    }
}
