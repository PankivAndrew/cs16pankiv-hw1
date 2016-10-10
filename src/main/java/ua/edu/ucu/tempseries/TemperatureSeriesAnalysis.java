package ua.edu.ucu.tempseries;
import java.lang.Math;

public class TemperatureSeriesAnalysis {
    double[] lst;
    int index = 0;
    public TemperatureSeriesAnalysis() {

    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        this.lst = temperatureSeries;
        //this.lst_length = temperatureSeries.length;

    }

    public double average() throws IllegalArgumentException {
        double sum = 0;
        if (lst.length == 0) {
            throw new IllegalArgumentException();
        } else {
            for (int i = 0; i < lst.length; i++) {
                sum += lst[i];
            }
            double averaga_temperature = sum / lst.length;
            return averaga_temperature;

        }
    }

    public double deviation() throws IllegalArgumentException {
        if(lst.length == 0 ){
            throw new IllegalArgumentException();
        }
        int sum = 0;
        if(lst.length == 0){
            throw new IllegalArgumentException();
        }
        for (int i = 1; i < lst.length; i ++){
            double x = Math.pow(lst[i] - average(),2);
            sum += x;
        }
        double devi = Math.sqrt(sum / lst.length);
        return devi;

    }

    public double min() throws IllegalArgumentException {
        if(lst.length == 0 ){
            throw new IllegalArgumentException();
        }
        double min = lst[0];
        for (int i = 1; i < lst.length;i++){
            if(lst[i] < min){
                min = lst[i];
            }
        }
        return min;
    }

    public double max() throws IllegalArgumentException {
        if(lst.length == 0 ){
            throw new IllegalArgumentException();
        }
        double max = lst[0];
        for (int i = 1; i < lst.length;i++){
            if(lst[i] > max){
                max = lst[i];
            }
        }
        return max;
    }

    public double findTempClosestToZero() throws IllegalArgumentException {
        if(lst.length == 0 ){
            throw new IllegalArgumentException();
        }
        double temptoZero = lst[0];
        double a;
        int index = 0;
        for(int i = 1; i < lst.length;i++){
            a = Math.abs(lst[i]);
            if(Math.abs(temptoZero) > a){
                temptoZero = a;
                index = i;
            }
            else if (Math.abs(temptoZero) == a && lst[i] > 0){
                index = i;
            }
        }
        return lst[index];

    }

    public double findTempClosestToValue(double tempValue) throws IllegalArgumentException {
        if(lst.length == 0 ){
            throw new IllegalArgumentException();
        }
        double temptoZero = lst[0];
        double a;
        int index = 0;
        for(int i = 1; i < lst.length;i++){
            a = Math.abs(lst[i] - tempValue);
            if(Math.abs(tempValue - temptoZero) > a){
                temptoZero = a;
                index = i;
            }
            else if (Math.abs(tempValue - temptoZero) == a && lst[i] > 0){
                index = i;
            }
        }
        return lst[index];
    }

    public double[] findTempsLessThen(double tempValue) throws IllegalArgumentException {
        if (lst.length == 0) {
            throw new IllegalArgumentException();
        }
        int counter = 0;
        for (int i = 0; i < lst.length; i++) {
            if (lst[i] < tempValue) {
                counter++;
            }
        }
        double[] lst1 = new double[counter];
        for (int i = 0; i < lst.length; i++) {
            if (lst[i] < tempValue) {
                lst1[i] = lst[i];
            }
        }
        return lst1;
    }

    public double[] findTempsGreaterThen(double tempValue) throws IllegalArgumentException{
            if (lst.length == 0) {
                throw new IllegalArgumentException();
            }
            int counter = 0;
            for (int i = 0; i < lst.length; i++) {
                if (lst[i] > tempValue) {
                    counter++;
                }
            }
            double[] lst2 = new double[counter];
            for (int i = 0; i < lst.length; i++) {
                if (lst[i] > tempValue) {
                    lst2[i] = lst[i];
                }
            }
            return lst2;
        }

    public TempSummaryStatistics summaryStatistics() {
        final TempSummaryStatistics Test1 = new TempSummaryStatistics(this.average(),this.deviation(),this.min(),this.max());
        return Test1;
    }

    public int addTemps(double... temps) throws IllegalArgumentException {
        int sum = 0;
        if (lst.length == 0) {
            throw new IllegalArgumentException();
        }
        if (lst[-1] == 0.0) {
            double_array();
            for (int i = 0; i < temps.length; i++) {
                lst[lst.length + 1] = temps[i];
            }

        }
        for (int i = 0; i < temps.length; i++) {
            lst[lst.length + 1] = temps[i];

        }
        for (int i = 0; i < lst.length; i++){
            sum += lst[i];
        }
        return sum;
    }
    public void double_array(){
        double[] lst1 = new double[lst.length * 2];
        for(int i = 0; i < lst.length;i++){
            lst1[i] = lst[i];

        }
        lst = lst1;

    }

}

