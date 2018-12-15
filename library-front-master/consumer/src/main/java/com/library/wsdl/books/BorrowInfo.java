//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.11 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2018.05.11 à 11:14:21 PM CEST 
//


package com.library.wsdl.books;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour borrowInfo complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="borrowInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="borrow_id" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="borrower" type="{http://libraryservice/books}userInfo"/&gt;
 *         &lt;element name="book" type="{http://libraryservice/books}bookInfo"/&gt;
 *         &lt;element name="term" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="extend" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "borrowInfo", propOrder = {
    "borrowId",
    "borrower",
    "book",
    "term",
    "extend"
})
public class BorrowInfo {

    @XmlElement(name = "borrow_id", required = true, type = Long.class, nillable = true)
    protected Long borrowId;
    @XmlElement(required = true)
    protected UserInfo borrower;
    @XmlElement(required = true)
    protected BookInfo book;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar term;
    protected boolean extend;

    /**
     * Obtient la valeur de la propriété borrowId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBorrowId() {
        return borrowId;
    }

    /**
     * Définit la valeur de la propriété borrowId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBorrowId(Long value) {
        this.borrowId = value;
    }

    /**
     * Obtient la valeur de la propriété borrower.
     * 
     * @return
     *     possible object is
     *     {@link UserInfo }
     *     
     */
    public UserInfo getBorrower() {
        return borrower;
    }

    /**
     * Définit la valeur de la propriété borrower.
     * 
     * @param value
     *     allowed object is
     *     {@link UserInfo }
     *     
     */
    public void setBorrower(UserInfo value) {
        this.borrower = value;
    }

    /**
     * Obtient la valeur de la propriété book.
     * 
     * @return
     *     possible object is
     *     {@link BookInfo }
     *     
     */
    public BookInfo getBook() {
        return book;
    }

    /**
     * Définit la valeur de la propriété book.
     * 
     * @param value
     *     allowed object is
     *     {@link BookInfo }
     *     
     */
    public void setBook(BookInfo value) {
        this.book = value;
    }

    /**
     * Obtient la valeur de la propriété term.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTerm() {
        return term;
    }

    /**
     * Définit la valeur de la propriété term.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTerm(XMLGregorianCalendar value) {
        this.term = value;
    }

    /**
     * Obtient la valeur de la propriété extend.
     * 
     */
    public boolean isExtend() {
        return extend;
    }

    /**
     * Définit la valeur de la propriété extend.
     * 
     */
    public void setExtend(boolean value) {
        this.extend = value;
    }

}
