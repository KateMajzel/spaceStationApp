package space_station;

public class SpeedCalculator {
    CalculatorParamiters calculatorParamiters = new CalculatorParamiters();
    public static double speedCalculator(CalculatorParamiters calculatorParamiters1){

        double result = Math.sqrt(Math.pow((calculatorParamiters1.getEndtLatitude() - calculatorParamiters1.getStartLatitude()), 2) + (Math.cos(calculatorParamiters1.getStartLatitude() * Math.PI / 180)) * (Math.pow((calculatorParamiters1.getEndLongitude() - calculatorParamiters1.getStartLongitude()), 2))) * (40075.704 / 360);
        double timeHour = (calculatorParamiters1.getEndTime()-calculatorParamiters1.getStartTime())/3600;
        double V = result/timeHour;

        return V;
    }

}
