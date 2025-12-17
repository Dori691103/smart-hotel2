package com.travel.booking.service;

import com.travel.booking.model.Booking;
import com.travel.booking.dto.BookingRequest;
import com.travel.booking.repository.BookingRepository;
import org.springframework.stereotype.Service;

@Service
public class HotelBookingService {

    private final BookingRepository bookingRepository;

    public HotelBookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking createBooking(BookingRequest request) {
        // 1. Проверка доступности номеров через PMS API
        boolean isAvailable = checkAvailability(request);
        if (!isAvailable) {
            throw new BookingException("Номера не доступны");
        }

        // 2. Расчёт цены
        Double totalPrice = calculatePrice(request);

        // 3. Создание БР
        Booking booking = new Booking();
        booking.setGuestName(request.getGuestName());
        booking.setEmail(request.getEmail());
        booking.setHotelName(request.getPreferredHotel());
        booking.setCheckIn(request.getCheckIn());
        booking.setCheckOut(request.getCheckOut());
        booking.setGuests(request.getAdults() + request.getChildren());
        booking.setStatus(BookingStatus.PENDING);
        booking.setTotalPrice(totalDesktopPrice);

        return bookingRepository.save(booking);
    }

    private boolean checkAvailability(BookingRequest request) {
        // Вызов PMS API
        return true; // упрощённо
    }

    private Double calculatePrice(BookingRequest request) {
        // Логика расчёта
        return 100.0; // упрощённо
    }
}
