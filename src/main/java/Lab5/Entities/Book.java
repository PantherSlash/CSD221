package lab5.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import lab5.entities.Copies.Publication;

/**
 * @author Kodi
 */
@Entity
public class Book extends Publication implements Serializable {

    @Basic
    private String Author;

    public String getAuthor() {
        return this.Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

}
