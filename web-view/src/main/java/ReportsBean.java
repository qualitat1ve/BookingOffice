
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.Date;

@ManagedBean
@SessionScoped
public class ReportsBean implements Serializable {
    private boolean enableReportsByDay;
    private boolean enableReportsByDestination = true;
    private Date startDate;
    private Date endDate;
    private CartesianChartModel daysModel;
    private CartesianChartModel destinationModel;

    public ReportsBean() {
        createDaysModel();
        createDestinationModel();
    }

    private void createDaysModel() {
        daysModel = new CartesianChartModel();
        ChartSeries days = new ChartSeries();
        days.setLabel("sold tickets");
        days.set("12.01.2013", 120);
        days.set("13.01.2013", 98);
        days.set("14.01.2013", 176);
        days.set("15.01.2013", 155);
        days.set("16.01.2013", 87);
        days.set("17.01.2013", 198);
        days.set("18.01.2013", 132);
        daysModel.addSeries(days);
    }

    private void createDestinationModel() {
        destinationModel = new CartesianChartModel();
        ChartSeries destinations = new ChartSeries();
        destinations.setLabel("Sold tickets");
        destinations.set("Vienna", 988);
        destinations.set("Moscow", 10999);
        destinations.set("Seoul", 677);
        destinations.set("Odessa", 22435);
        destinations.set("Lvov", 9223);
        destinations.set("New York", 1432);
        destinations.set("Ankara", 378);
        destinationModel.addSeries(destinations);

    }

    public boolean isEnableReportsByDay() {
        return enableReportsByDay;
    }

    public void setEnableReportsByDay(boolean enableReportsByDay) {
        this.enableReportsByDay = enableReportsByDay;
    }

    public boolean isEnableReportsByDestination() {
        return enableReportsByDestination;
    }

    public void setEnableReportsByDestination(boolean enableReportsByDestination) {
        this.enableReportsByDestination = enableReportsByDestination;
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

    public boolean isDaysChartDisabled() {
        return !enableReportsByDay;
    }


    public boolean isDestinationChartDisabled() {
        return  !enableReportsByDestination;
    }
}
