import org.apache.commons.lang3.builder.HashCodeBuilder;



public class Journey {

	private static int idCount = 1;
	private int id;
	private String origin;
	private String destination;
	private String contentType;
	private String company;
	
	
	public Journey(String origin, String destination, String contentType, String company) {
		this.origin = origin;
		this.destination = destination;
		this.contentType =  contentType;
		this.company = company;
		this.id = idCount;
		idCount++;
	}
	
	
	
	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin =origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
		
		
	}
	
	public String getContentType() {
		return contentType;
	}

	public String getCompany() {
		return company;
	}
		

	

	
	public String toString() {
		return "Origin: "+ origin + ". Destination:" + destination;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Journey) {
			Journey compare = (Journey) obj;
			return origin.equals(compare.origin) && destination.equals(compare.destination)&& contentType.equals(compare.contentType);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(17,37).append(origin).append(destination).append(contentType).append(id).toHashCode();
	}



	public void update(String origin, String destination, String contentType, String company) {
		this.origin = origin;
		this.destination = destination;
		this.contentType = contentType;
		this.company = company;
	}
	
	
	
	

}
