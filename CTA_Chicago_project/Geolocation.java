// Robert Shyroian, This class is responsible for the geolocation of a particular station

package project;

public class Geolocation {
	
	double Latitude;
	double Longitude;
	
	public Geolocation() {
		Latitude = 0;
		Longitude = 0;
	}
	
	public Geolocation(double Latitude, double Longitude) {
		this.Latitude = Latitude;
		this.Longitude = Longitude;
	}
	
	//get latitude
	public double getLatitude() {
		return Latitude;
	}
	
	//set latitude
	public void setLatitude(double Latitude) {
		this.Latitude = Latitude;
	}
	
	//get longitude
	public double getLongitude() {
		return Longitude;
	}
	
	//set longitude
	public void setLongitude(double Longitude) {
		this.Longitude = Longitude;
	}
	
	//distance from this station to (lat, lon)
	public double distance(double lat, double lon) {

		double lon1 = Math.toRadians(lon);
		double lon2 = Math.toRadians(this.Longitude);
		double lat1 = Math.toRadians(lat);
		double lat2 = Math.toRadians(this.Latitude);

		double dlon = lon2 - lon1;
		double dlat = lat2 - lat1;
		double a = Math.pow(Math.sin(dlat / 2), 2)
		        + Math.cos(lat1) * Math.cos(lat2)
		        * Math.pow(Math.sin(dlon / 2),2);
    
		double c = 2 * Math.asin(Math.sqrt(a));

		double r = 3956;

		return (c * r);
	}
	
	public String toString() {
		return "Latitude: " + Latitude + ", Longitude: " + Longitude;
	}
}
