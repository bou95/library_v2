//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.11 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2019.01.15 à 02:53:57 PM CET 
//


package com.library.ws.reservations;

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
 *         &lt;element name="reservationInfo" type="{http://libraryservice/reservations}reservationInfo"/&gt;
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
    "reservationInfo"
})
@XmlRootElement(name = "getReservationByBookResponse")
public class GetReservationByBookResponse {

    @XmlElement(required = true)
    protected ReservationInfo reservationInfo;

    /**
     * Obtient la valeur de la propriété reservationInfo.
     * 
     * @return
     *     possible object is
     *     {@link ReservationInfo }
     *     
     */
    public ReservationInfo getReservationInfo() {
        return reservationInfo;
    }

    /**
     * Définit la valeur de la propriété reservationInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link ReservationInfo }
     *     
     */
    public void setReservationInfo(ReservationInfo value) {
        this.reservationInfo = value;
    }

}
