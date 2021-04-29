package dk.dtu.management.model;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import dk.dtu.management.dao.ContainerStatusDao;

@Entity
@Table(name = "container_status")
public class ContainerStatus {
	@Transient
	private ContainerStatusDao statusDao = new ContainerStatusDao();
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "container_status_id", unique = true)
	private int id;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "container_fk", referencedColumnName = "container_id")
	private Container container;
	@Column(name = "temperature", nullable = false)
	private double temperature;
	@Column(name = "humidity", nullable = false)
	private double humidity;
	@Column(name = "pressure", nullable = false)
	private double pressure;
	@Column(name = "time", nullable = false)
	private Date time;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "journey_fk", referencedColumnName = "journey_id", nullable = true)
	private Journey journey;
	
	public ContainerStatus() {}
	public ContainerStatus(double temperature, double humidity, double pressure) {
		super();
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		Calendar c = Calendar.getInstance();
		c.setTimeZone(TimeZone.getTimeZone("Europe/Copenhagen"));
		this.time = c.getTime();
		statusDao.save(this);
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
		statusDao.update(this);
	}
	public double getHumidity() {
		return humidity;
	}
	public void setHumidity(double humidity) {
		this.humidity = humidity;
		statusDao.update(this);
	}
	public double getPressure() {
		return pressure;
	}
	public void setPressure(double pressure) {
		this.pressure = pressure;
		statusDao.update(this);
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
		statusDao.update(this);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
		statusDao.update(this);
	}
	public Container getContainer() {
		return container;
	}
	public void setContainer(Container container) {
		this.container = container;
		statusDao.update(this);
	}
	
	
	
	
	

}
