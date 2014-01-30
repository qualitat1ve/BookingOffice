import com.kukushkin.booking.office.entity.Flight;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ManagedBean
@SessionScoped
public class ReservationBean {
    private String customerName;
    private String customerMiddleName;
    private String customerSurname;
    private int bookedTicket = 1;
    private double summaryTicketsPrice;
    private List<Flight> reservedFlights = new ArrayList<>();
    private Map<Flight, Integer> reservedTickets = new HashMap<>();

    public ReservationBean() {
    }


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerMiddleName() {
        return customerMiddleName;
    }

    public void setCustomerMiddleName(String customerMiddleName) {
        this.customerMiddleName = customerMiddleName;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public void setCustomerSurname(String customerSurname) {
        this.customerSurname = customerSurname;
    }

    public int getBookedTicket() {
        return bookedTicket;
    }

    public void setBookedTicket(int bookedTicket) {
        this.bookedTicket = bookedTicket;
    }

    public double getSummaryTicketsPrice() {
        return summaryTicketsPrice;
    }

    public void setSummaryTicketsPrice(double summaryTicketsPrice) {
        this.summaryTicketsPrice = summaryTicketsPrice;
    }

    public List<Flight> getReservedFlights() {
        return reservedFlights;
    }

    public void setReservedFlights(List<Flight> reservedFlights) {
        this.reservedFlights = reservedFlights;
    }

    public double calculateSummaryTicketsPrice(double price) {
        summaryTicketsPrice = bookedTicket * price;
        return summaryTicketsPrice;
    }

    public int detectTicketsNumber(Flight flight) {
        int number = 0;
        for (Map.Entry<Flight, Integer> entry : reservedTickets.entrySet()) {
            if(entry.getKey().equals(flight)) number = entry.getValue();
        }
        return number;
    }

    public void removeFromReservation(Flight flight) {
        reservedTickets.remove(flight);
    }

    public Map<Flight, Integer> getReservedTickets() {
        return reservedTickets;
    }

    public void setReservedTickets(Map<Flight, Integer> reservedTickets) {
        this.reservedTickets = reservedTickets;
    }

    public String addToReservation(Flight flight) {
        reservedTickets.put(flight, bookedTicket);
        return null;
    }

    public int totalPrice() {

        //TODO: implement
        int price = 100;
        return price;
    }

}
