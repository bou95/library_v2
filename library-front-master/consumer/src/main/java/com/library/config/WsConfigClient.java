package com.library.config;

import com.library.client.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class WsConfigClient {


    /*
    Config Books
     */
        @Bean
        public Jaxb2Marshaller marshallerBooks() {
            Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
            marshaller.setContextPath("com.library.wsdl.books");
            return marshaller;
        }

        @Bean
        public BooksClient booksClient(Jaxb2Marshaller marshallerBooks) {
            BooksClient client = new BooksClient();
            client.setDefaultUri("http://localhost:8080/ws/books.wsdl");
            client.setMarshaller(marshallerBooks);
            client.setUnmarshaller(marshallerBooks);
            return client;
        }

        /*
        Config Users
         */
        @Bean
        public Jaxb2Marshaller marshallerUsers() {
            Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
            marshaller.setContextPath("com.library.wsdl.users");
            return marshaller;
        }

        @Bean
        public UsersClient usersClient(Jaxb2Marshaller marshallerUsers) {
            UsersClient client = new UsersClient();
            client.setDefaultUri("http://localhost:8080/ws/users.wsdl");
            client.setMarshaller(marshallerUsers);
            client.setUnmarshaller(marshallerUsers);
        return client;
        }

        /*
        Config borrows
         */
        @Bean
        public Jaxb2Marshaller marshallerBorrows() {
            Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
            marshaller.setContextPath("com.library.wsdl.borrows");
            return marshaller;
        }

        @Bean
        public BorrowsClient borrowsClient(Jaxb2Marshaller marshallerBorrows) {
            BorrowsClient client = new BorrowsClient();
            client.setDefaultUri("http://localhost:8080/ws/borrows.wsdl");
            client.setMarshaller(marshallerBorrows);
            client.setUnmarshaller(marshallerBorrows);
            return client;
        }

        /*
        Config employees
         */
        @Bean
        public Jaxb2Marshaller marshallerEmployees() {
            Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
            marshaller.setContextPath("com.library.wsdl.employees");
            return marshaller;
        }

        @Bean
        public EmployeesClient employeesClient(Jaxb2Marshaller marshallerEmployees) {
            EmployeesClient client = new EmployeesClient();
            client.setDefaultUri("http://localhost:8080/ws/employees.wsdl");
            client.setMarshaller(marshallerEmployees);
            client.setUnmarshaller(marshallerEmployees);
            return client;
        }

    /*
    Config reservation
     */
    @Bean
    public Jaxb2Marshaller marshallerReservations() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.library.wsdl.reservations");
        return marshaller;
    }

    @Bean
    public ReservationClient reservationClient(Jaxb2Marshaller marshallerReservations) {
        ReservationClient client = new ReservationClient();
        client.setDefaultUri("http://localhost:8080/ws/reservations.wsdl");
        client.setMarshaller(marshallerReservations);
        client.setUnmarshaller(marshallerReservations);
        return client;
    }
}
