//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.11 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2019.02.11 à 06:02:28 PM CET 
//


package com.library.ws.users;

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
 *         &lt;element name="user_id" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="remind" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
    "userId",
    "remind"
})
@XmlRootElement(name = "remindCheckboxRequest")
public class RemindCheckboxRequest {

    @XmlElement(name = "user_id")
    protected long userId;
    protected boolean remind;

    /**
     * Obtient la valeur de la propriété userId.
     * 
     */
    public long getUserId() {
        return userId;
    }

    /**
     * Définit la valeur de la propriété userId.
     * 
     */
    public void setUserId(long value) {
        this.userId = value;
    }

    /**
     * Obtient la valeur de la propriété remind.
     * 
     */
    public boolean isRemind() {
        return remind;
    }

    /**
     * Définit la valeur de la propriété remind.
     * 
     */
    public void setRemind(boolean value) {
        this.remind = value;
    }

}
