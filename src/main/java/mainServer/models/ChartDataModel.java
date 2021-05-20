package mainServer.models;


//to send the chartdata to frontend
public class ChartDataModel {
    private String label;
    private String value;

    public ChartDataModel(){

    }

    public ChartDataModel(String label,String value){
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    
}
