package mainServer.models;

import java.util.*;

//model that incorporates more than 1 chart model so that single api call is enough to retrive any number of chartdata. Right now only 2 is needed
public class HistoryModel {
    private ChartSetting chartSetting1;
    private ChartSetting chartSetting2;
    private ArrayList<ChartDataModel> chartData1;
    private ArrayList<ChartDataModel> chartData2;

    public HistoryModel(){

    }

    
    public HistoryModel(ChartSetting chartSetting1, ChartSetting chartSetting2, ArrayList<ChartDataModel> chartData1,
            ArrayList<ChartDataModel> chartData2) {
        this.chartSetting1 = chartSetting1;
        this.chartSetting2 = chartSetting2;
        this.chartData1 = chartData1;
        this.chartData2 = chartData2;
    }


    
    public ChartSetting getChartSetting1() {
        return chartSetting1;
    }


    public void setChartSetting1(ChartSetting chartSetting1) {
        this.chartSetting1 = chartSetting1;
    }


    public ChartSetting getChartSetting2() {
        return chartSetting2;
    }


    public void setChartSetting2(ChartSetting chartSetting2) {
        this.chartSetting2 = chartSetting2;
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
