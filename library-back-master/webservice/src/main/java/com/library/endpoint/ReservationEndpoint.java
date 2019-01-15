package com.library.endpoint;

import com.library.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;

@Endpoint
public class ReservationEndpoint {

    @Autowired
    ReservationService reservationService;

}
