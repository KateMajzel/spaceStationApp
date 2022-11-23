package space_station;

public class CalculatorParamiters {

    private double startTime;
    private double endTime;
    private double startLatitude;
    private double endtLatitude;
    private double startLongitude;
    private double endLongitude;

    public CalculatorParamiters() {
    }

    public CalculatorParamiters(double startTime, double endTime, double startLatitude, double endtLatitude, double startLongitude, double endLongitude) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.startLatitude = startLatitude;
        this.endtLatitude = endtLatitude;
        this.startLongitude = startLongitude;
        this.endLongitude = endLongitude;
    }

    public double getStartTime() {
        return startTime;
    }

    public double getEndTime() {
        return endTime;
    }

    public double getStartLatitude() {
        return startLatitude;
    }

    public double getEndtLatitude() {
        return endtLatitude;
    }

    public double getStartLongitude() {
        return startLongitude;
    }

    public double getEndLongitude() {
        return endLongitude;
    }
}
