package com.travel.booking.controller;

import com.travel.booking.service.HotelBookingService;
import com.travel.booking.dto.BookingRequest;
import com.travel.booking.model.Booking;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class HotelBookingController {

    private final HotelBookingService bookingService;

    public HotelBookingController(HotelBookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public Booking bookHotel(@RequestBody BookingRequest request) {
        return bookingService.createBooking(request);
    }

    @GetMapping("/{id}")
    public Booking getBooking(@PathVariable Long id) {
        return bookingService.getBooking(id);
    }
}
