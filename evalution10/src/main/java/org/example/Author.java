package org.example;

import javax.persistence.*;
import org.example.Book;
import java.util.List;
import java.util.Set;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aId;
    private String aName;
    @OneToMany(mappedBy = "author")
    private List<Book> bookSet;

    public Author() {
    }

    public List<Book> getBookSet() {
        return bookSet;
    }



    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    @Override
    public String toString() {
        return "org.example.Author{" +
                "aId=" + aId +
                ", aName='" + aName + '\'' +
                ", bookSet=" + bookSet +
                '}';
    }

    public void setBookSet(List<org.example.Book> bookSet) {

    }
}
