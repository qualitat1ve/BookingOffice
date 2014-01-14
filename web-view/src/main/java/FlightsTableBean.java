import com.kukushkin.booking.office.entity.Flight;
import org.primefaces.event.RowEditEvent;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

@ManagedBean
@SessionScoped
public class FlightsTableBean implements Serializable {
    private ArrayList<Flight> flightsList;
    private String date;
    private String destinationPlace;
    private String[] departurePlaces;
    private String[] arrivalPlaces;

    public FlightsTableBean() {
        initFakeDeparturePlaces();
        iniFakeArrivalPlaces();
        initFakeFlights();
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

    private void initFakeFlights() {
        flightsList = new ArrayList<Flight>();
        Flight flight = new Flight();
        flight.setArrival("Kiev");
        flight.setArrivalDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
        flight.setDepartureDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
        flight.setDeparture("Vienna");
        flight.setTicketNumber(20);
        flight.setTicketPrice(1000);
        Flight flight2 = new Flight();
        flight2.setArrival("Odessa");
        flight2.setArrivalDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
        flight2.setDepartureDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
        flight2.setDeparture("Moscow");
        flight2.setTicketNumber(10);
        flight2.setTicketPrice(2000);
        Flight flight3 = new Flight();
        flight2.setArrival("Lvov");
        flight2.setArrivalDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
        flight2.setDepartureDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
        flight2.setDeparture("Seoul");
        flight2.setTicketNumber(140);
        flight2.setTicketPrice(800);

        flightsList.add(flight);
        flightsList.add(flight2);
        flightsList.add(flight3);
    }

    public ArrayList<Flight> getFlightsList() {
        return flightsList;
    }

    public void setFlightsList(ArrayList<Flight> flightsList) {
        this.flightsList = flightsList;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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
            return "foundFlights";
        } else return "noFlightsFound";
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
}
