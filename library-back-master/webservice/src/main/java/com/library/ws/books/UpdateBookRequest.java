//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.11 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2019.01.17 à 03:15:05 PM CET 
//


package com.library.ws.books;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="bookInfo" type="{http://libraryservice/books}bookInfo"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "bookInfo"
})
@XmlRootElement(name = "updateBookRequest")
public class UpdateBookRequest {

    @XmlElement(required = true)
    protected BookInfo bookInfo;

    /**
     * Obtient la valeur de la propriété bookInfo.
     * 
     * @return
     *     possible object is
     *     {@link BookInfo }
     *     
     */
    public BookInfo getBookInfo() {
        return bookInfo;
    }

    /**
     * Définit la valeur de la propriété bookInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link BookInfo }
     *     
     */
    public void setBookInfo(BookInfo value) {
        this.bookInfo = value;
    }

}
