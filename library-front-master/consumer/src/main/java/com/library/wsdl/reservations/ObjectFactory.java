//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.11 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2019.02.11 à 06:03:35 PM CET 
//


package com.library.wsdl.reservations;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.library.wsdl.reservations package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.library.wsdl.reservations
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
     * Create an instance of {@link GetAllReservationsRequest }
     * 
     */
    public GetAllReservationsRequest createGetAllReservationsRequest() {
        return new GetAllReservationsRequest();
    }

    /**
     * Create an instance of {@link GetAllReservationsResponse }
     * 
     */
    public GetAllReservationsResponse createGetAllReservationsResponse() {
        return new GetAllReservationsResponse();
    }

    /**
     * Create an instance of {@link GetAllReservationsByUserRequest }
     * 
     */
    public GetAllReservationsByUserRequest createGetAllReservationsByUserRequest() {
        return new GetAllReservationsByUserRequest();
    }

    /**
     * Create an instance of {@link GetAllReservationsByUserResponse }
     * 
     */
    public GetAllReservationsByUserResponse createGetAllReservationsByUserResponse() {
        return new GetAllReservationsByUserResponse();
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
