// Robert Shyroian, This class is responsible for the details of a particular station
package project;

public class Station extends Geolocation {
	
	int id;
	String Name;
	String Description;
	boolean Wheelchair;
	int Red;
	int Green;
	int Blue;
	int Brown;
	int Purple;
	int Pink;
	int Orange;
	
	public Station() {
		super();
		id = 0;
		Name  = "Test";
		Description = "elevated";
		Wheelchair = true;
		Red = -1;
		Green = -1;
		Blue = -1;
		Brown = -1;
		Purple = -1;
		Pink = -1;
		Orange = -1;
	}
	
	public Station(int id, String Name, double Latitude, double Longitude, String Description, boolean Wheelchair, int Red, int Green, int Blue, int Brown, int Purple, int Pink, int Orange) {
		super(Latitude, Longitude);
		this.id = id;
		this.Name = Name;
		this.Description = "elevated";
		this.Wheelchair = Wheelchair;
		this.Red = Red;
		this.Green = Green;
		this.Blue = Blue;
		this.Brown = Brown;
		this.Purple = Purple;
		this.Pink = Pink;
		this.Orange = Orange;
	}
	
	//get Id
	public int getId() {
		return id;
	}
	
	// set Id
	public void setId(int id) {
		this.id = id;
	}
	
	// get name
	public String getName() {
		return Name;
	}
	
	// set name
	public void setName(String Name) {
		this.Name = Name;
	}
	
	// get description
	public String getDescription() {
		return Description;
	}
	
	//set description
	public void setDescription(String Description) {
		this.Description = Description;
	}
	
	//get wheelchair
	public boolean getWheelchair() {
		return Wheelchair;
	}
	
	//set wheelchair
	public void setWheelchair(boolean Wheelchair) {
		this.Wheelchair = Wheelchair;
	}
	
	//get and set colors below
	public int getRed() {
		return Red;
	}
	
	public void setRed(int Red) {
		this.Green = Red;
	}
	
	public int getGreen() {
		return Green;
	}
	
	public void setGreen(int Green) {
		this.Green = Green;
	}
	
	public int getBlue() {
		return Blue;
	}
	
	public void setBlue(int Blue) {
		this.Blue = Blue;
	}
	
	public int getBrown() {
		return Brown;
	}
	
	public void setBrown(int Brown) {
		this.Brown = Brown;
	}
	
	public int getPurple() {
		return Purple;
	}
	
	public void setPurple(int Purple) {
		this.Purple = Purple;
	}
	
	public int getPink() {
		return Pink;
	}
	
	public void setPink(int Pink) {
		this.Pink = Pink;
	}
	
	public int getOrange() {
		return Orange;
	}
	
	public void setOrange(int Orange) {
		this.Orange = Orange;
	}
	
	//to string
	public String toString() {
		return "Id: " + id + ". Name: " + Name + ", Latitude: " + Latitude + ", Longitude: " + Longitude + ", Description: " + Description + ", Wheelchair accessibility: " + Wheelchair;
	}
	
}
