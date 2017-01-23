/*
 * SE1021
 * Winter 2017
 * Name: Brad Dennis, Ph.D.
 * Created: 01/22/2017
 */

package lecture12;

import java.text.ParseException;

/**
 * A simple class that holds a row of weather data from our data text file.
 */
public class WeatherRecord {
    private static final int DATETIME_COL = 0;
    private static final int RAINFALL_COL = 0;
    private static final int HUMIDITY_COL = 0;
    private static final int TEMPERATURE_COL = 0;

    public String datetime;
    public double rainfall;
    public double humidity;
    public double temperature;


    public static WeatherRecord fromDataFile(String data) throws ParseException{
        WeatherRecord record = new WeatherRecord();
        String[] fields = data.split(",");
        record.datetime = fields[DATETIME_COL];
        record.rainfall = Double.parseDouble(fields[RAINFALL_COL]);
        record.humidity = Double.parseDouble(fields[HUMIDITY_COL]);
        record.temperature = Double.parseDouble(fields[TEMPERATURE_COL]);

        return record;
    }
}
