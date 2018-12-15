package entities;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class Books {

    private Long book_id;

    @Size(message="Le titre du livre doit contenir au moins un caractère",min=1)
    private String title;

    @NotNull
    private String category;

    @NotNull
    private String author;

    private Long available;

    private List<Borrows> borrows;

    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getAvailable() {
        return available;
    }

    public void setAvailable(Long available) {
        this.available = available;
    }

    public List<Borrows> getBorrows() {
        return borrows;
    }

    public void setBorrows(List<Borrows> borrows) {
        this.borrows = borrows;
    }
}
