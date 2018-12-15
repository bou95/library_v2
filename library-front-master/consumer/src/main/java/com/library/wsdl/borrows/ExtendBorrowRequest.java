//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.11 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2018.05.11 à 11:14:22 PM CEST 
//


package com.library.wsdl.borrows;

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
 *         &lt;element name="borrow_id" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="extend" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
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
    "borrowId",
    "extend"
})
@XmlRootElement(name = "extendBorrowRequest")
public class ExtendBorrowRequest {

    @XmlElement(name = "borrow_id", required = true, type = Long.class, nillable = true)
    protected Long borrowId;
    protected Boolean extend;

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
     * Obtient la valeur de la propriété extend.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isExtend() {
        return extend;
    }

    /**
     * Définit la valeur de la propriété extend.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExtend(Boolean value) {
        this.extend = value;
    }

}
