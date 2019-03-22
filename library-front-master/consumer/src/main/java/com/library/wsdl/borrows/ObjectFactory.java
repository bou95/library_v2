//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.11 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2019.02.11 à 06:03:35 PM CET 
//


package com.library.wsdl.borrows;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.library.wsdl.borrows package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.library.wsdl.borrows
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetBorrowByIdRequest }
     * 
     */
    public GetBorrowByIdRequest createGetBorrowByIdRequest() {
        return new GetBorrowByIdRequest();
    }

    /**
     * Create an instance of {@link GetBorrowByIdResponse }
     * 
     */
    public GetBorrowByIdResponse createGetBorrowByIdResponse() {
        return new GetBorrowByIdResponse();
    }

    /**
     * Create an instance of {@link BorrowInfo }
     * 
     */
    public BorrowInfo createBorrowInfo() {
        return new BorrowInfo();
    }

    /**
     * Create an instance of {@link AddBorrowRequest }
     * 
     */
    public AddBorrowRequest createAddBorrowRequest() {
        return new AddBorrowRequest();
    }

    /**
     * Create an instance of {@link AddBorrowResponse }
     * 
     */
    public AddBorrowResponse createAddBorrowResponse() {
        return new AddBorrowResponse();
    }

    /**
     * Create an instance of {@link ServiceStatus }
     * 
     */
    public ServiceStatus createServiceStatus() {
        return new ServiceStatus();
    }

    /**
     * Create an instance of {@link ExtendBorrowRequest }
     * 
     */
    public ExtendBorrowRequest createExtendBorrowRequest() {
        return new ExtendBorrowRequest();
    }

    /**
     * Create an instance of {@link ExtendBorrowResponse }
     * 
     */
    public ExtendBorrowResponse createExtendBorrowResponse() {
        return new ExtendBorrowResponse();
    }

    /**
     * Create an instance of {@link DeleteBorrowRequest }
     * 
     */
    public DeleteBorrowRequest createDeleteBorrowRequest() {
        return new DeleteBorrowRequest();
    }

    /**
     * Create an instance of {@link DeleteBorrowResponse }
     * 
     */
    public DeleteBorrowResponse createDeleteBorrowResponse() {
        return new DeleteBorrowResponse();
    }

    /**
     * Create an instance of {@link GetAllBorrowsRequest }
     * 
     */
    public GetAllBorrowsRequest createGetAllBorrowsRequest() {
        return new GetAllBorrowsRequest();
    }

    /**
     * Create an instance of {@link GetAllBorrowsResponse }
     * 
     */
    public GetAllBorrowsResponse createGetAllBorrowsResponse() {
        return new GetAllBorrowsResponse();
    }

    /**
     * Create an instance of {@link GetAllOutdatedBorrowsRequest }
     * 
     */
    public GetAllOutdatedBorrowsRequest createGetAllOutdatedBorrowsRequest() {
        return new GetAllOutdatedBorrowsRequest();
    }

    /**
     * Create an instance of {@link GetAllOutdatedBorrowsResponse }
     * 
     */
    public GetAllOutdatedBorrowsResponse createGetAllOutdatedBorrowsResponse() {
        return new GetAllOutdatedBorrowsResponse();
    }

    /**
     * Create an instance of {@link UserInfo }
     * 
     */
    public UserInfo createUserInfo() {
        return new UserInfo();
    }

    /**
     * Create an instance of {@link BookInfo }
     * 
     */
    public BookInfo createBookInfo() {
        return new BookInfo();
    }

}
