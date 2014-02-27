
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class ReportsBean implements Serializable {
    private Date startDate;
    private Date endDate;
    private CartesianChartModel daysModel;
    private CartesianChartModel destinationModel;
    //may be removed in feature
    private boolean chartsDisabled = false;

    public ReportsBean() {
        daysModel = new CartesianChartModel();
        destinationModel = new CartesianChartModel();
    }
    
    public void generateReports() {
        createDaysModel();
        createDestinationModel();
        setChartsDisabled(false);
    }

    private void createDaysModel() {
        daysModel.clear();
        ChartSeries days = new ChartSeries();
        days.setLabel("sold tickets");
        days.set("12.01.2013", generateRandomNumber(200));
        days.set("13.01.2013", generateRandomNumber(200));
        days.set("14.01.2013", generateRandomNumber(200));
        days.set("15.01.2013", generateRandomNumber(200));
        days.set("16.01.2013", generateRandomNumber(200));
        days.set("17.01.2013", generateRandomNumber(200));
        days.set("18.01.2013", generateRandomNumber(200));
        daysModel.addSeries(days);
    }

    private void createDestinationModel() {
        destinationModel.clear();
        ChartSeries destinations = new ChartSeries();
        destinations.setLabel("Sold tickets");
        destinations.set("Vienna", generateRandomNumber(23000));
        destinations.set("Moscow", generateRandomNumber(23000));
        destinations.set("Seoul", generateRandomNumber(23000));
        destinations.set("Odessa", generateRandomNumber(23000));
        destinations.set("Lvov", generateRandomNumber(23000));
        destinations.set("New York", generateRandomNumber(23000));
        destinations.set("Ankara", generateRandomNumber(2020));
        destinationModel.addSeries(destinations);
    }
    
    
    private int generateRandomNumber(int range) {
    	Random rnd = new Random(); 
    	return rnd.nextInt(range);
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public CartesianChartModel getDaysModel() {
        return daysModel;
    }

    public void setDaysModel(CartesianChartModel daysModel) {
        this.daysModel = daysModel;
    }

    public CartesianChartModel getDestinationModel() {
        return destinationModel;
    }

    public void setDestinationModel(CartesianChartModel destinationModel) {
        this.destinationModel = destinationModel;
    }

	public boolean isChartsDisabled() {
		return chartsDisabled;
	}

	public void setChartsDisabled(boolean chartsDisabled) {
		this.chartsDisabled = chartsDisabled;
	}
}
