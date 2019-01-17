//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.11 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2019.01.17 à 03:15:06 PM CET 
//


package com.library.ws.borrows;

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
 *         &lt;element name="borrowInfo" type="{http://libraryservice/borrows}borrowInfo"/&gt;
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
    "borrowInfo"
})
@XmlRootElement(name = "getBorrowByIdResponse")
public class GetBorrowByIdResponse {

    @XmlElement(required = true)
    protected BorrowInfo borrowInfo;

    /**
     * Obtient la valeur de la propriété borrowInfo.
     * 
     * @return
     *     possible object is
     *     {@link BorrowInfo }
     *     
     */
    public BorrowInfo getBorrowInfo() {
        return borrowInfo;
    }

    /**
     * Définit la valeur de la propriété borrowInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link BorrowInfo }
     *     
     */
    public void setBorrowInfo(BorrowInfo value) {
        this.borrowInfo = value;
    }

}
