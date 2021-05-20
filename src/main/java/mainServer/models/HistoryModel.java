package mainServer.models;

import java.util.*;

//model that incorporates more than 1 chart model so that single api call is enough to retrive any number of chartdata. Right now only 2 is needed
public class HistoryModel {
    private ArrayList<ChartDataModel> chartData1;
    private ArrayList<ChartDataModel> chartData2;

    public HistoryModel(){

    }

    public HistoryModel(ArrayList<ChartDataModel> chartData1,ArrayList<ChartDataModel> chartData2){
        this.chartData1 = chartData1;
        this.chartData2 = chartData2;
    }


    public ArrayList<ChartDataModel> getChartData1() {
        return chartData1;
    }

    public void setChartData1(ArrayList<ChartDataModel> chartData1) {
        this.chartData1 = chartData1;
    }

    public ArrayList<ChartDataModel> getChartData2() {
        return chartData2;
    }

    public void setChartData2(ArrayList<ChartDataModel> chartData2) {
        this.chartData2 = chartData2;
    }
    
    
}
