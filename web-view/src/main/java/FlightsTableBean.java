import com.kukushkin.booking.office.entity.Flight;
import org.primefaces.event.RowEditEvent;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@ManagedBean
@SessionScoped
public class FlightsTableBean implements Serializable {
    private ArrayList<Flight> flightsList;
    private ArrayList<FakeFlight> createdFlights = new ArrayList<FakeFlight>();
    private FakeFlight flight = new FakeFlight();
    private Date date;
    private String destinationPlace;
    private String[] departurePlaces;
    private String[] arrivalPlaces;
    private String selectedFlightNumber;


    public FlightsTableBean() {
        initFakeDeparturePlaces();
        iniFakeArrivalPlaces();
        initTestFlights();
    }

    private void iniFakeArrivalPlaces() {
        arrivalPlaces = new String[5];
        arrivalPlaces[0] = "Kiev";
        arrivalPlaces[1] = "Odessa";
        arrivalPlaces[2] = "Lvov";
        arrivalPlaces[3] = "Kharkov";
        arrivalPlaces[4] = "Dnepropetrovsk";
    }

    private void initFakeDeparturePlaces() {
        departurePlaces = new String[5];
        departurePlaces[0] = "Vienna";
        departurePlaces[1] = "Moscow";
        departurePlaces[2] = "Seoul";
        departurePlaces[3] = "Sophia";
        departurePlaces[4] = "Prague";
    }

    private void initTestFlights() {
        flightsList = new ArrayList<Flight>();
        Flight flight = new Flight();
        flight.setArrival("Kiev");
        flight.setFlightNumber("N87HHM123GG");
        flight.setArrivalDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
        flight.setDepartureDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
        flight.setDeparture("Vienna");
        flight.setTicketNumber(20);
        flight.setTicketPrice(1000);
        Flight flight2 = new Flight();
        flight2.setArrival("Odessa");
        flight2.setFlightNumber("H20N2SO4HCL98");
        flight2.setArrivalDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
        flight2.setDepartureDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
        flight2.setDeparture("Moscow");
        flight2.setTicketNumber(10);
        flight2.setTicketPrice(2000);
        Flight flight3 = new Flight();
        flight3.setArrival("Lvov");
        flight3.setFlightNumber("N2CO3C2SO4FE2O3");
        flight3.setArrivalDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
        flight3.setDepartureDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
        flight3.setDeparture("Seoul");
        flight3.setTicketNumber(140);
        flight3.setTicketPrice(800);

        flightsList.add(flight);
        flightsList.add(flight2);
        flightsList.add(flight3);
    }

    public String addFlightsToTimetable() {
        for (FakeFlight fakeFlight: createdFlights) {
            Flight flight = new Flight();
            flight.setFlightNumber(fakeFlight.getFlightNumber());
            flight.setArrival(fakeFlight.getArrival());
            flight.setDeparture(fakeFlight.getDeparture());
            flight.setArrivalDate(new Timestamp(fakeFlight.getArrivalDate().getTime()));
            flight.setDepartureDate(new Timestamp(fakeFlight.getDepartureDate().getTime()));
            flight.setCreationDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
            flight.setTicketNumber(fakeFlight.getTicketNumber());
            flight.setTicketPrice(fakeFlight.getTicketPrice());
            flightsList.add(flight);
        }
        createdFlights.clear();
        return null;
    }

    public String reInit() {
        flight = new FakeFlight();
        return null;
    }

    public String copyAndReInit() {
        for (Flight realFlight : flightsList) {
            if (realFlight.getFlightNumber().equals(selectedFlightNumber)) {
                flight.setFlightNumber(realFlight.getFlightNumber());
                flight.setDeparture(realFlight.getDeparture());
                flight.setArrival(realFlight.getArrival());
                flight.setDepartureDate(new Date(realFlight.getDepartureDate().getTime()));
                flight.setArrivalDate(new Date(realFlight.getArrivalDate().getTime()));
                flight.setTicketNumber(realFlight.getTicketNumber());
                flight.setTicketPrice(realFlight.getTicketPrice());
                break;
            }
        }
        return null;
    }

    public FakeFlight getFlight() {
        return flight;
    }

    public void setFlight(FakeFlight flight) {
        this.flight = flight;
    }

    public ArrayList<FakeFlight> getCreatedFlights() {
        return createdFlights;
    }

    public void setCreatedFlights(ArrayList<FakeFlight> createdFlights) {
        this.createdFlights = createdFlights;
    }

    public ArrayList<Flight> getFlightsList() {
        return flightsList;
    }

    public void setFlightsList(ArrayList<Flight> flightsList) {
        this.flightsList = flightsList;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDestinationPlace() {
        return destinationPlace;
    }

    public void setDestinationPlace(String destinationPlace) {
        this.destinationPlace = destinationPlace;
    }

    public String findFlights() {
        if(destinationPlace.equals("Antananarivo")) {
            return "foundFlights.xhtml";
        } else return "noFlightsFound.xhtml";
    }

    public String[] getDeparturePlaces() {
        return departurePlaces;
    }

    public void setDeparturePlaces(String[] departurePlaces) {
        this.departurePlaces = departurePlaces;
    }

    public String[] getArrivalPlaces() {
        return arrivalPlaces;
    }

    public void setArrivalPlaces(String[] arrivalPlaces) {
        this.arrivalPlaces = arrivalPlaces;
    }

    public void onEdit(RowEditEvent event) {
//        FacesMessage msg = new FacesMessage("Flight Edited", ((Flight) event.getObject()).getFlightNumber());
//        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCancel(RowEditEvent event) {
//        FacesMessage msg = new FacesMessage("Flight editing cancelled", ((Flight) event.getObject()).getFlightNumber());
//        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public String getSelectedFlightNumber() {
        return selectedFlightNumber;
    }

    public void setSelectedFlightNumber(String selectedFlightNumber) {
        this.selectedFlightNumber = selectedFlightNumber;
    }
}
