//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.11 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2019.01.17 à 03:15:06 PM CET 
//


package com.library.ws.reservations;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.library.ws.reservations package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.library.ws.reservations
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddReservationRequest }
     * 
     */
    public AddReservationRequest createAddReservationRequest() {
        return new AddReservationRequest();
    }

    /**
     * Create an instance of {@link AddReservationResponse }
     * 
     */
    public AddReservationResponse createAddReservationResponse() {
        return new AddReservationResponse();
    }

    /**
     * Create an instance of {@link ServiceStatus }
     * 
     */
    public ServiceStatus createServiceStatus() {
        return new ServiceStatus();
    }

    /**
     * Create an instance of {@link ReservationInfo }
     * 
     */
    public ReservationInfo createReservationInfo() {
        return new ReservationInfo();
    }

    /**
     * Create an instance of {@link GetReservationByIdRequest }
     * 
     */
    public GetReservationByIdRequest createGetReservationByIdRequest() {
        return new GetReservationByIdRequest();
    }

    /**
     * Create an instance of {@link GetReservationByIdResponse }
     * 
     */
    public GetReservationByIdResponse createGetReservationByIdResponse() {
        return new GetReservationByIdResponse();
    }

    /**
     * Create an instance of {@link DeleteReservationRequest }
     * 
     */
    public DeleteReservationRequest createDeleteReservationRequest() {
        return new DeleteReservationRequest();
    }

    /**
     * Create an instance of {@link DeleteReservationResponse }
     * 
     */
    public DeleteReservationResponse createDeleteReservationResponse() {
        return new DeleteReservationResponse();
    }

    /**
     * Create an instance of {@link BookInfo }
     * 
     */
    public BookInfo createBookInfo() {
        return new BookInfo();
    }

    /**
     * Create an instance of {@link UserInfo }
     * 
     */
    public UserInfo createUserInfo() {
        return new UserInfo();
    }

}
