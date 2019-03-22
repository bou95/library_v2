package entities;

public class Reservation {

    private Long res_Id;

    private Books book;

    private Users borrower;

    private Integer index;

    public Long getRes_Id() {
        return res_Id;
    }

    public void setRes_Id(Long res_Id) {
        this.res_Id = res_Id;
    }

    public Books getBook() {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
    }

    public Users getBorrower() {
        return borrower;
    }

    public void setBorrower(Users borrower) {
        this.borrower = borrower;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
