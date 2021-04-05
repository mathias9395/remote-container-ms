import java.sql.Time;
import java.util.*;

public class Container {
	private static int idCount = 1;
	private int id;
	private Client client;
	private String location;
	private ArrayList<Double> temperatures;
	private ArrayList<Double> humidities;
	private ArrayList<Double> pressures;
	private ArrayList<Date> timeStamps;
	

	public Container(Client client, String location) {
		this.client = client;
		client.addContainer(this);
		this.location = location;
		idCount++;
		temperatures = new ArrayList<Double>();
		humidities = new ArrayList<Double>();
		pressures = new ArrayList<Double>();
		timeStamps = new ArrayList<Date>();
	}
	
	public void addStatusEntry(double temp, double humidity, double pressure) {
		temperatures.add(temp);
		humidities.add(humidity);
		pressures.add(pressure);
		Date date = new Date();
		timeStamps.add(date);
	}
	
	public double getCurrentTemp() {
		if (temperatures.size() > 0) {
			return temperatures.get(temperatures.size()-1);
		}
		else {
			return 0.0;
		}
	}
	public double getCurrentHumidity() {
		if (humidities.size() > 0) {
			return humidities.get(humidities.size()-1);
		}
		else {
			return 0.0;
		}
	}
	public double getCurrentPressure() {
		if (pressures.size() > 0) {
			return pressures.get(pressures.size()-1);
		}
		else {
			return 0.0;
		}
	}
	public Date getCurrentTime() {
		if (timeStamps.size() > 0) {
			return timeStamps.get(timeStamps.size()-1);
		}
		else {
			return null;
		}
	}
}
