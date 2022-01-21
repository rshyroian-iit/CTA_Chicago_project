// Robert Shyroian, This class is responsible for the user interface
package project;

import java.util.ArrayList;
import java.util.Scanner;

public class ctaApp {
	//list of stations
	public static ArrayList<Station> stations;
	
	//user interface
	public static void main(String[] args) {
		stations = new ArrayList<Station>();
		stations = Data.readExistingFile();
		Scanner input = new Scanner(System.in);
		boolean bool = true;
		while(bool) {
			System.out.println("CTA: Enter a number between 1 and 8:\n" +
					"1. Create a station.\n" +
					"2. Modify a station.\n" +
					"3. Remore a station.\n" +
					"4. Search by name.\n" +
					"5. Find by filter.\n" +
					"6. Find the nearest station.\n" +
					"7. Path between two stations.\n" +
					"8. Exit.");
			
			String in = input.nextLine();
			
			switch(in) {
				case "1":
					Data.addStation();
					stations = Data.stations;
					break;
				case "2":
					Data.modifyStation();
					stations = Data.stations;
					break;
				case "3":
					Data.removeStation();
					stations = Data.stations;
					break;
				case "4":
					Data.searchStation();
					break;
				case "5":
					Data.filterStation();
					break;
				case "6":
					Data.nearestStation();
					break;
				case "7":
					Data.pathStation();
					break;
				case "8":
					System.out.println("Goodbye!");
					bool = false;
					break;
				default:
					System.out.println("Bad input.");
			}
		}
		input.close();
		
		//resulting list
		for (Station station: stations) {
			System.out.println(station);
		}
	}
	
}
