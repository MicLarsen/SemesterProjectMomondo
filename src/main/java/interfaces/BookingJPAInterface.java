package interfaces;

import entities.BookingInfo;

/**
 *
 * @author nickl
 */
public interface BookingJPAInterface {
    
    public BookingInfo insertBookingInf(BookingInfo bi);
    
    public BookingInfo retrieveBookingInf(String email, String flightNumber);
    
    public BookingInfo updateBookingInf(BookingInfo bi);
    
    public boolean deleteBookingInf(BookingInfo bi);
}
