//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.11 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2019.02.11 à 06:03:33 PM CET 
//


package com.library.wsdl.books;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour reservationInfo complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="reservationInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="res_id" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="book" type="{http://libraryservice/books}bookInfo"/&gt;
 *         &lt;element name="borrowers" type="{http://libraryservice/books}userInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="index" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reservationInfo", propOrder = {
    "resId",
    "book",
    "borrowers",
    "index"
})
public class ReservationInfo {

    @XmlElement(name = "res_id", required = true, type = Long.class, nillable = true)
    protected Long resId;
    @XmlElement(required = true)
    protected BookInfo book;
    protected List<UserInfo> borrowers;
    @XmlElement(required = true)
    protected BigInteger index;

    /**
     * Obtient la valeur de la propriété resId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getResId() {
        return resId;
    }

    /**
     * Définit la valeur de la propriété resId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setResId(Long value) {
        this.resId = value;
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
     * Gets the value of the borrowers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the borrowers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBorrowers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UserInfo }
     * 
     * 
     */
    public List<UserInfo> getBorrowers() {
        if (borrowers == null) {
            borrowers = new ArrayList<UserInfo>();
        }
        return this.borrowers;
    }

    /**
     * Obtient la valeur de la propriété index.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIndex() {
        return index;
    }

    /**
     * Définit la valeur de la propriété index.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIndex(BigInteger value) {
        this.index = value;
    }

}
