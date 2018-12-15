package entities;

import javax.xml.datatype.XMLGregorianCalendar;

public class Borrows {

    private Long borrow_Id;

    private Books book;

    private Users borrower;

    private XMLGregorianCalendar term;

    private Boolean extend;

    public Long getBorrow_Id() {
        return borrow_Id;
    }

    public void setBorrow_Id(Long borrow_Id) {
        this.borrow_Id = borrow_Id;
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

    public XMLGregorianCalendar getTerm() {
        return term;
    }

    public void setTerm(XMLGregorianCalendar term) {
        this.term = term;
    }

    public Boolean getExtend() {
        return extend;
    }

    public void setExtend(Boolean extend) {
        this.extend = extend;
    }
}
