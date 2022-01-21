// Robert Shyroian, This class is responsible for the execution of the users requests, all main calculations are made here.

package project;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Data {
	
	//list of stations
	public static ArrayList<Station> stations;
	
	//function that reads the file with stations
	public static ArrayList<Station> readExistingFile() {
		
		stations = new ArrayList<Station>();
		
		try {
			File in = new File("src/project/CTAStops.csv");
			Scanner input = new Scanner(in);
			int i = -1;
			while (input.hasNextLine()) {
				try {
					String line = input.nextLine();
					Station s = null;
					String[] values = line.split(",");
					s = new Station(i++, values[0], Double.parseDouble(values[1]), Double.parseDouble(values[2]), values[3], Boolean.parseBoolean(values[4]), Integer.parseInt(values[5]), Integer.parseInt(values[6]), Integer.parseInt(values[7]), Integer.parseInt(values[8]), Integer.parseInt(values[9]), Integer.parseInt(values[10]), Integer.parseInt(values[11]));
					if (s != null) {
						stations.add(s);
					}
				} catch(Exception e) {
					if (i != 0)
						System.out.println("Error reading row");
				}
			}
			input.close();
		} catch (Exception e) {
			System.out.println("Error reading file");
		}
		
		return stations;
	}
	
	//function that adds a station
	public static void addStation() {
		
		int id = stations.size();
		String Name;
		double Latitude;
		double Longitude;
		String Description;
		boolean Wheelchair;
		int Red;
		int Green;
		int Blue;
		int Brown;
		int Purple;
		int Pink;
		int Orange;
		
		Scanner input = new Scanner(System.in);
		
		// Name
		System.out.println("Enter the name of the station: ");
		String in = input.nextLine();
		Name = in;
		
		// Latitude
		while(true) {
			System.out.println("Latitude of the station:");
			in = input.nextLine();
			try {
				Latitude = Double.parseDouble(in);
				if (Math.abs(Latitude) <= 90 )
					break;
				else
					System.out.println("Enter a number between -90 and 90.");
			} catch (Exception e) {
				System.out.println("Wrong input. Enter an double.");
			}
		}
		
		// Longitude
		while(true) {
			System.out.println("Longitude of the station:");
			in = input.nextLine();
			try {
				Longitude = Double.parseDouble(in);
				if (Math.abs(Longitude) <= 180 )
					break;
				else
					System.out.println("Enter a number between -180 and 180.");
			} catch (Exception e) {
				System.out.println("Wrong input. Enter an double.");
			}
		}
		
		// Description
		System.out.println("Enter the description of the station: ");
		in = input.nextLine();
		Description = in;
		
		// Wheelchair
		while(true) {
			System.out.println("Does the station have weelchair access? Enter Y or N: ");
			in = input.nextLine();
			if (in.compareToIgnoreCase("y") == 0) {
				Wheelchair = true;
				break;
			} else if (in.compareToIgnoreCase("n") == 0) {
				Wheelchair = false;
				break;
			}
			else {
				System.out.println("Wrong input. Just enter Y or N.");
			}
		}
		
		// Red
		while(true) {
			System.out.println("Which station is it on the red line? Enter a non negative integer or -1 if it is not on the red line:");
			in = input.nextLine();
			try {
				Red = Integer.parseInt(in);
				if (Red >= -1)
					break;
				else
					System.out.println("Enter a non nnegative integer or -1.");
			} catch (Exception e) {
				System.out.println("Wrong input. Enter an integer.");
			}
		}
		
		// Green
		while(true) {
			System.out.println("Which station is it on the green line? Enter a non negative integer or -1 if it is not on the green line:");
			in = input.nextLine();
			try {
				Green = Integer.parseInt(in);
				if (Green >= -1)
					break;
				else
					System.out.println("Enter a non nnegative integer or -1.");
			} catch (Exception e) {
				System.out.println("Wrong input. Enter an integer.");
			}
		}
		
		// Blue
		while(true) {
			System.out.println("Which station is it on the blue line? Enter a non negative integer or -1 if it is not on the blue line:");
			in = input.nextLine();
			try {
				Blue = Integer.parseInt(in);
				if (Blue >= -1)
					break;
				else
					System.out.println("Enter a non nnegative integer or -1.");
			} catch (Exception e) {
				System.out.println("Wrong input. Enter an integer.");
			}
		}
		
		// Brown
		while(true) {
			System.out.println("Which station is it on the brown line? Enter a non negative integer or -1 if it is not on the brown line:");
			in = input.nextLine();
			try {
				Brown = Integer.parseInt(in);
				if (Brown >= -1)
					break;
				else
					System.out.println("Enter a non nnegative integer or -1.");
			} catch (Exception e) {
				System.out.println("Wrong input. Enter an integer.");
			}
		}
		
		// Purple
		while(true) {
			System.out.println("Which station is it on the purple line? Enter a non negative integer or -1 if it is not on the purple line:");
			in = input.nextLine();
			try {
				Purple = Integer.parseInt(in);
				if (Purple >= -1)
					break;
				else
					System.out.println("Enter a non nnegative integer or -1.");
			} catch (Exception e) {
				System.out.println("Wrong input. Enter an integer.");
			}
		}
		
		// Pink
		while(true) {
			System.out.println("Which station is it on the pink line? Enter a non negative integer or -1 if it is not on the pink line:");
			in = input.nextLine();
			try {
				Pink = Integer.parseInt(in);
				if (Pink >= -1)
					break;
				else
					System.out.println("Enter a non nnegative integer or -1.");
			} catch (Exception e) {
				System.out.println("Wrong input. Enter an integer.");
			}
		}
		
		// Orange
		while(true) {
			System.out.println("Which station is it on the orange line? Enter a non negative integer or -1 if it is not on the orange line:");
			in = input.nextLine();
			try {
				Orange = Integer.parseInt(in);
				if (Orange >= -1)
					break;
				else
					System.out.println("Enter a non nnegative integer or -1.");
			} catch (Exception e) {
				System.out.println("Wrong input. Enter an integer.");
			}
		}
		
		// Adjusting the values
		for (Station station: stations) {
			if (Red != -1 && station.getRed() > Red)
				station.setRed(station.getRed() + 1);
			if (Green != -1 && station.getGreen() > Green)
				station.setGreen(station.getGreen() + 1);
			if (Blue != -1 && station.getBlue() > Blue)
				station.setBlue(station.getBlue() + 1);
			if (Brown != -1 && station.getBrown() > Brown)
				station.setBrown(station.getBrown() + 1);
			if (Purple != -1 && station.getPurple() > Purple)
				station.setPurple(station.getPurple() + 1);
			if (Pink != -1 && station.getPink() > Pink)
				station.setPink(station.getPink() + 1);
			if (Orange != -1 && station.getOrange() > Orange)
				station.setOrange(station.getOrange() + 1);
		}

		Station s = new Station(id, Name, Latitude, Longitude, Description, Wheelchair, Red, Green, Blue, Brown, Purple, Pink, Orange);
		stations.add(s);
		//input.close();
	}
	
	//function that removes a station
	public static void removeStation() {
		
		ArrayList<Station> temp = new ArrayList<Station>();
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("Enter the name of the station which you would like to remove: ");
		String in = input.nextLine();
		for (Station station: stations) {
			if(station.getName().equalsIgnoreCase(in)) {
				temp.add(station);
			}
		}
		
		if(temp.size() == 0)
			System.out.println("A station with the name " + in + " does not exist.");
		
		if (temp.size() == 1) {
			int Red = temp.get(0).getRed();
			int Green = temp.get(0).getGreen();
			int Blue = temp.get(0).getBlue();
			int Brown = temp.get(0).getBrown();
			int Purple = temp.get(0).getPurple();
			int Pink = temp.get(0).getPink();
			int Orange = temp.get(0).getOrange();
			
			for (Station station: stations) {
				if (Red != -1 && station.getRed() > Red)
					station.setRed(station.getRed() - 1);
				if (Green != -1 && station.getGreen() > Green)
					station.setGreen(station.getGreen() - 1);
				if (Blue != -1 && station.getBlue() > Blue)
					station.setBlue(station.getBlue() - 1);
				if (Brown != -1 && station.getBrown() > Brown)
					station.setBrown(station.getBrown() - 1);
				if (Purple != -1 && station.getPurple() > Purple)
					station.setPurple(station.getPurple() - 1);
				if (Pink != -1 && station.getPink() > Pink)
					station.setPink(station.getPink() - 1);
				if (Orange != -1 && station.getOrange() > Orange)
					station.setOrange(station.getOrange() - 1);
				
				stations.remove(temp.get(0).getId());
			}
		}
		
		if (temp.size() > 1) {
			
			System.out.println("We found the following stations that match the name of the station you entered:");
			int i = -1;
			int j = -1;
			for (Station s: temp) {
				i++;
				System.out.println(i + ". " + s);
			}
			
			while (true) {
				try {
					System.out.println("Enter a number of the station between 0 and " + i + ": ");
					in = input.nextLine();
					j = Integer.parseInt(in);
					if (j >= 0 && j <= i) {
						break;
					}
				} catch (Exception e) {
					System.out.println("Wrong input. Enter an integer.");
				}
			}
			
			int id = temp.get(j).getId();
			int Red = temp.get(j).getRed();
			int Green = temp.get(j).getGreen();
			int Blue = temp.get(j).getBlue();
			int Brown = temp.get(j).getBrown();
			int Purple = temp.get(j).getPurple();
			int Pink = temp.get(j).getPink();
			int Orange = temp.get(j).getOrange();
			
			for (Station station: stations) {
				if (station.getId() > id)
					station.setId(station.getId() - 1);
				if (Red != -1 && station.getRed() > Red)
					station.setRed(station.getRed() - 1);
				if (Green != -1 && station.getGreen() > Green)
					station.setGreen(station.getGreen() - 1);
				if (Blue != -1 && station.getBlue() > Blue)
					station.setBlue(station.getBlue() - 1);
				if (Brown != -1 && station.getBrown() > Brown)
					station.setBrown(station.getBrown() - 1);
				if (Purple != -1 && station.getPurple() > Purple)
					station.setPurple(station.getPurple() - 1);
				if (Pink != -1 && station.getPink() > Pink)
					station.setPink(station.getPink() - 1);
				if (Orange != -1 && station.getOrange() > Orange)
					station.setOrange(station.getOrange() - 1);
			}
			stations.remove(temp.get(j).getId());
		}
		
		//input.close();
	}

	//function that modifies a station
	public static void modifyStation() {

		
		ArrayList<Station> temp = new ArrayList<Station>();
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("Enter the name of the station which you would like to modify: ");
		String in = input.nextLine();
		for (Station station: stations) {
			if(station.getName().equalsIgnoreCase(in)) {
				temp.add(station);
			}
		}
		
		if(temp.size() == 0)
			System.out.println("A station with the name " + in + " does not exist.");
		
		if (temp.size() > 1) {
			
			System.out.println("We found the following stations that match the name of the station you entered:");
			int i = -1;
			int j = -1;
			for (Station s: temp) {
				i++;
				System.out.println(i + ". " + s);
			}
			
			while (true) {
				try {
					System.out.println("Enter a number of the station between 0 and " + i + ": ");
					in = input.nextLine();
					j = Integer.parseInt(in);
					if (j >= 0 && j <= i) {
						break;
					}
				} catch (Exception e) {
					System.out.println("Wrong input. Enter an integer.");
				}
			}
			
			ArrayList<Station> station = new ArrayList<Station>();
			station.add(temp.get(j));
			temp = station;
		}
		
		if (temp.size() == 1) {
			boolean stop = false;
			System.out.println(temp.get(0));
			while(!stop) {
				System.out.println("Select what you would like to modify:\n"
						+ "1. Name\n"
						+ "2. Latitude\n"
						+ "3. Longitude\n"
						+ "4. Description\n"
						+ "5. Wheelchair\n"
						+ "6. Red\n"
						+ "7. Green\n"
						+ "8. Blue\n"
						+ "9. Brown\n"
						+ "10. Purple\n"
						+ "11. Pink\n"
						+ "12. Orange");
			
				in = input.nextLine();
				
				switch(in) {
					case "1":
						System.out.println("Enter a new name:");
						String name = input.nextLine();
						stop = true;
						stations.get(temp.get(0).getId()).setName(name);
						System.out.println(stations.get(temp.get(0).getId()));
						break;
					case "2":
						double latitude;
						while (true) {
							System.out.println("Enter a new latitude:");
							String lat = input.nextLine();
							try {
								latitude = Double.parseDouble(lat);
								if (Math.abs(latitude) < 90)
									break;
								else
									System.out.println("Enter a number between -90 and 90.");
							} catch (Exception e) {
								System.out.println("Wrong input. Enter a double.");
							}
						}
						stop = true;
						stations.get(temp.get(0).getId()).setLatitude(latitude);
						break;
					case "3":
						double longitude;
						while (true) {
							System.out.println("Enter a new longitude:");
							String lon = input.nextLine();
							try {
								longitude = Double.parseDouble(lon);
								if (Math.abs(longitude) < 180)
									break;
								else
									System.out.println("Enter a number between -180 and 180.");
							} catch (Exception e) {
								System.out.println("Wrong input. Enter a double.");
							}
						}
						stop = true;
						stations.get(temp.get(0).getId()).setLongitude(longitude);
						break;
					case "4":
						System.out.println("Enter a new description:");
						String description = input.nextLine();
						stop = true;
						stations.get(temp.get(0).getId()).setDescription(description);
						break;
					case "5":
						boolean wheelchair;
						while (true) {
							System.out.println("Does it have a wheelchair access? Enter Y or N");
							String wc = input.nextLine();
							if (wc.compareToIgnoreCase("y") == 0) {
								wheelchair = true;
								break;
							} else if (wc.compareToIgnoreCase("n") == 0) {
								wheelchair = false;
								break;
							} else {
								System.out.println("Wrong input. Enter Y or N.");
							}		
						}
						stop = true;
						stations.get(temp.get(0).getId()).setWheelchair(wheelchair);
						break;
					case "6":
						int red;
						while (true) {
							System.out.println("Enter a new non negative value for red or enter -1:");
							String c = input.nextLine();
							try {
								red = Integer.parseInt(c);
								if (red >= -1)
									break;
								else
									System.out.println("Enter a number between higher or equal to -1.");
							} catch (Exception e) {
								System.out.println("Wrong input. Enter an integer.");
							}
						}
						stop = true;
						int old_red = stations.get(temp.get(0).getId()).getRed();
						for (Station station: stations) {
							if (old_red != -1 && station.getRed() > old_red)
								station.setRed(station.getRed() - 1);
						}
						for (Station station: stations) {
							if (red != -1 && station.getRed() >= red)
								station.setRed(station.getRed() + 1);
						}
						stations.get(temp.get(0).getId()).setRed(red);
						break;
					case "7":
						int green;
						while (true) {
							System.out.println("Enter a new non negative value for green or enter -1:");
							String c = input.nextLine();
							try {
								green = Integer.parseInt(c);
								if (green >= -1)
									break;
								else
									System.out.println("Enter a number between higher or equal to -1.");
							} catch (Exception e) {
								System.out.println("Wrong input. Enter an integer.");
							}
						}
						stop = true;
						int old_green = stations.get(temp.get(0).getId()).getGreen();
						for (Station station: stations) {
							if (old_green != -1 && station.getGreen() > old_green)
								station.setGreen(station.getGreen() - 1);
						}
						for (Station station: stations) {
							if (green != -1 && station.getGreen() >= green)
								station.setGreen(station.getGreen() + 1);
						}
						stations.get(temp.get(0).getId()).setRed(green);
						break;
					case "8":
						int blue;
						while (true) {
							System.out.println("Enter a new non negative value for blue or enter -1:");
							String c = input.nextLine();
							try {
								blue = Integer.parseInt(c);
								if (blue >= -1)
									break;
								else
									System.out.println("Enter a number between higher or equal to -1.");
							} catch (Exception e) {
								System.out.println("Wrong input. Enter an integer.");
							}
						}
						stop = true;
						int old_blue = stations.get(temp.get(0).getId()).getBlue();
						for (Station station: stations) {
							if (old_blue != -1 && station.getBlue() > old_blue)
								station.setBlue(station.getBlue() - 1);
						}
						for (Station station: stations) {
							if (blue != -1 && station.getBlue() >= blue)
								station.setBlue(station.getBlue() + 1);
						}
						stations.get(temp.get(0).getId()).setBlue(blue);
						break;
					case "9":
						int brown;
						while (true) {
							System.out.println("Enter a new non negative value for brown or enter -1:");
							String c = input.nextLine();
							try {
								brown = Integer.parseInt(c);
								if (brown >= -1)
									break;
								else
									System.out.println("Enter a number between higher or equal to -1.");
							} catch (Exception e) {
								System.out.println("Wrong input. Enter an integer.");
							}
						}
						stop = true;
						int old_brown = stations.get(temp.get(0).getId()).getBrown();
						for (Station station: stations) {
							if (old_brown != -1 && station.getBrown() > old_brown)
								station.setBrown(station.getBrown() - 1);
						}
						for (Station station: stations) {
							if (brown != -1 && station.getBrown() >= brown)
								station.setBrown(station.getBrown() + 1);
						}
						stations.get(temp.get(0).getId()).setBrown(brown);
						break;
					case "10":
						int purple;
						while (true) {
							System.out.println("Enter a new non negative value for purple or enter -1:");
							String c = input.nextLine();
							try {
								purple = Integer.parseInt(c);
								if (purple >= -1)
									break;
								else
									System.out.println("Enter a number between higher or equal to -1.");
							} catch (Exception e) {
								System.out.println("Wrong input. Enter an integer.");
							}
						}
						stop = true;
						int old_purple = stations.get(temp.get(0).getId()).getPurple();
						for (Station station: stations) {
							if (old_purple != -1 && station.getPurple() > old_purple)
								station.setPurple(station.getPurple() - 1);
						}
						for (Station station: stations) {
							if (purple != -1 && station.getPurple() >= purple)
								station.setPurple(station.getPurple() + 1);
						}
						stations.get(temp.get(0).getId()).setPurple(purple);
						break;
					case "11":
						int pink;
						while (true) {
							System.out.println("Enter a new non negative value for pink or enter -1:");
							String c = input.nextLine();
							try {
								pink = Integer.parseInt(c);
								if (pink >= -1)
									break;
								else
									System.out.println("Enter a number between higher or equal to -1.");
							} catch (Exception e) {
								System.out.println("Wrong input. Enter an integer.");
							}
						}
						stop = true;
						int old_pink = stations.get(temp.get(0).getId()).getPink();
						for (Station station: stations) {
							if (old_pink != -1 && station.getPink() > old_pink)
								station.setPink(station.getPink() - 1);
						}
						for (Station station: stations) {
							if (pink != -1 && station.getPink() >= pink)
								station.setPink(station.getPink() + 1);
						}
						stations.get(temp.get(0).getId()).setPink(pink);
						break;
					case "12":
						int orange;
						while (true) {
							System.out.println("Enter a new non negative value for orange or enter -1:");
							String c = input.nextLine();
							try {
								orange = Integer.parseInt(c);
								if (orange >= -1)
									break;
								else
									System.out.println("Enter a number between higher or equal to -1.");
							} catch (Exception e) {
								System.out.println("Wrong input. Enter an integer.");
							}
						}
						stop = true;
						int old_orange = stations.get(temp.get(0).getId()).getOrange();
						for (Station station: stations) {
							if (old_orange != -1 && station.getOrange() > old_orange)
								station.setOrange(station.getOrange() - 1);
						}
						for (Station station: stations) {
							if (orange != -1 && station.getOrange() >= orange)
								station.setOrange(station.getOrange() + 1);
						}
						stations.get(temp.get(0).getId()).setOrange(orange);
						break;
					default:
						System.out.println("Wrong input. Enter a number from 1 to 12.");
				}
			}
		}
		
		//input.close();
	}
	
	//function that searches a station by name
	public static void searchStation() {
		
		ArrayList<Station> temp = new ArrayList<Station>();
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("Enter the name of the station which you would like to find: ");
		String in = input.nextLine();
		for (Station station: stations) {
			if(station.getName().equalsIgnoreCase(in)) {
				temp.add(station);
			}
		}
		
		if(temp.size() == 0)
			System.out.println("A station with the name " + in + " does not exist.");
		
		if (temp.size() == 1) {
			System.out.println(temp.get(0));
		}
		
		if (temp.size() > 1) {
			
			System.out.println("We found the following stations that match the name of the station you entered:");
			int i = -1;
			int j = -1;
			for (Station s: temp) {
				i++;
				System.out.println(i + ". " + s);
			}
			
			while (true) {
				try {
					System.out.println("Enter a number of the station between 0 and " + i + ": ");
					in = input.nextLine();
					j = Integer.parseInt(in);
					if (j >= 0 && j <= i) {
						break;
					}
				} catch (Exception e) {
					System.out.println("Wrong input. Enter an integer.");
				}
			}
			System.out.println(temp.get(j));
		}
		//input.close();
	}
	
	//function that searches for stations by the filter
	public static void filterStation() {
		
		ArrayList<Station> temp = new ArrayList<Station>();
		ArrayList<Station> temp1 = new ArrayList<Station>();
		Scanner input = new Scanner(System.in);
		
		System.out.println("Would you like the station to have a wheelcheir accessibility:\n" +
							"1. Yes							2. Skip");
		int j;
		while (true) {
			try {
				String in = input.nextLine();
				j = Integer.parseInt(in);
				if (j == 1 || j == 2) {
					break;
				}
			} catch (Exception e) {
				System.out.println("Wrong input. Enter an integer.");
			}
		}
		if (j == 1) {
			for (Station station: stations) {
				if (station.getWheelchair()) {
					temp.add(station);
				}
			}
		}
		else {
			System.out.println("Skipping.");
			temp = stations;
		}
		
		System.out.println("Would you like the station to be on a specific line:\n" +
				"1. Red		2.Green		3. Blue		4. Brown	5. Purple	6. Pink		7. Orange	8. Skip");
		while (true) {
			try {
				String in = input.nextLine();
				j = Integer.parseInt(in);
				if (j > 0 && j < 9)
					break;
				else
					System.out.println("Enter a number between 1 and 8:");
			} catch (Exception e) {
				System.out.println("Wrong input. Enter an integer.");
			}
		}
		if (j == 1) {
			for (Station station: temp) {
				if (station.getRed() > -1) {
					temp1.add(station);
				}
			}
		}
		else if (j == 2) {
			for (Station station: temp) {
				if (station.getGreen() > -1) {
					temp1.add(station);
				}
			}
		}
		else if (j == 3) {
			for (Station station: temp) {
				if (station.getBlue() > -1) {
					temp1.add(station);
				}
			}
		}
		else if (j == 4) {
			for (Station station: temp) {
				if (station.getBrown() > -1) {
					temp1.add(station);
				}
			}
		}
		else if (j == 5) {
			for (Station station: temp) {
				if (station.getPurple() > -1) {
					temp1.add(station);
				}
			}
		}
		else if (j == 6) {
			for (Station station: temp) {
				if (station.getPink() > -1) {
					temp1.add(station);
				}
			}
		}
		else if (j == 7) {
			for (Station station: temp) {
				if (station.getOrange() > -1) {
					temp1.add(station);
				}
			}
		}
		else {
			temp1 = temp;
			System.out.println("Skipping.");
		}
		temp = temp1;
		if (temp.size() == 0)
			System.out.println("Station with these filters do not exist.");
		else {
			for (Station station: temp) {
				System.out.println(station);
			}
		}
		//input.close();
	}
	
	//function that finds that closest station
	public static void nearestStation() {
		ArrayList<Station> temp = new ArrayList<Station>();
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter your latitude:");
		double lat;
		while (true) {
			try {
				String in = input.nextLine();
				lat = Double.parseDouble(in);
				if (Math.abs(lat) <= 90)
					break;
				else
					System.out.println("Enter a number between -90 and 90:");
			} catch (Exception e) {
				System.out.println("Wrong input. Enter a double.");
			}
		}
		
		System.out.println("Enter your longitude:");
		double lon;
		while (true) {
			try {
				String in = input.nextLine();
				lon = Double.parseDouble(in);
				if (Math.abs(lon) <= 180)
					break;
				else
					System.out.println("Enter a number between -180 and 180:");
			} catch (Exception e) {
				System.out.println("Wrong input. Enter a double.");
			}
		}
		double min = stations.get(0).distance(lat, lon);
		int index = 0;
		for (Station s: stations) {
			if (s.distance(lat, lon) < min) {
				min = s.distance(lat, lon);
				index = s.getId();
			}
		}
		System.out.println("The closest station is:\n" + stations.get(index));
		System.out.println("The distance is " + min + " miles.");
		
		//input.close();
	}
	
	//function that requests the source and destination stations and then calls route function
	public static void pathStation() {
		int init = -1, dest = -1;
		ArrayList<Station> temp = new ArrayList<Station>();
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("Enter the name of the source station: ");
		String in = input.nextLine();
		for (Station station: stations) {
			if(station.getName().equalsIgnoreCase(in)) {
				temp.add(station);
			}
		}
		
		if(temp.size() == 0) {
			System.out.println("A station with the name " + in + " does not exist.");
			pathStation();
		}
		
		if (temp.size() == 1) {
			System.out.println(temp.get(0));
			init = temp.get(0).getId();
		}
		
		if (temp.size() > 1) {
			
			System.out.println("We found the following stations that match the name of the station you entered:");
			int i = -1;
			int j = -1;
			for (Station s: temp) {
				i++;
				System.out.println(i + ". " + s);
			}
			
			while (true) {
				try {
					System.out.println("Enter a number of the station between 0 and " + i + ": ");
					in = input.nextLine();
					j = Integer.parseInt(in);
					if (j >= 0 && j <= i) {
						break;
					}
				} catch (Exception e) {
					System.out.println("Wrong input. Enter an integer.");
				}
			}
			System.out.println(temp.get(j));
			init = temp.get(j).getId();
		}
		
		temp.clear();
		if (init != -1) {
			System.out.println("Enter the name of the destination station: ");
			in = input.nextLine();
			for (Station station: stations) {
				if(station.getName().equalsIgnoreCase(in)) {
					temp.add(station);
				}
			}
			
			if(temp.size() == 0) {
				System.out.println("A station with the name " + in + " does not exist.");
				pathStation();
			}
			
			if (temp.size() == 1) {
				System.out.println(temp.get(0));
				dest = temp.get(0).getId();
			}
			
			if (temp.size() > 1) {
				
				System.out.println("We found the following stations that match the name of the station you entered:");
				int i = -1;
				int j = -1;
				for (Station s: temp) {
					i++;
					System.out.println(i + ". " + s);
				}
				
				while (true) {
					try {
						System.out.println("Enter a number of the station between 0 and " + i + ": ");
						in = input.nextLine();
						j = Integer.parseInt(in);
						if (j >= 0 && j <= i) {
							break;
						}
					} catch (Exception e) {
						System.out.println("Wrong input. Enter an integer.");
					}
				}
				System.out.println(temp.get(j));
				dest = temp.get(j).getId();
			}
			if (dest != -1)
				route(init, dest);
		}
		//input.close();
	}
	
	//function which finds the route from the source station to the destination station
	public static void route(int init, int dest) {
		int redi = stations.get(init).getRed();
		int greeni = stations.get(init).getGreen();
		int bluei = stations.get(init).getBlue();
		int browni = stations.get(init).getBrown();
		int purplei = stations.get(init).getPurple();
		int pinki = stations.get(init).getPink();
		int orangei = stations.get(init).getOrange();
		int redf = stations.get(dest).getRed();
		int greenf = stations.get(dest).getGreen();
		int bluef = stations.get(dest).getBlue();
		int brownf = stations.get(dest).getBrown();
		int purplef = stations.get(dest).getPurple();
		int pinkf = stations.get(dest).getPink();
		int orangef = stations.get(dest).getOrange();
		if ((redi > -1 && redf > -1) || (greeni > -1 && greenf > -1) || (bluei > -1 && bluef > -1) || (browni > -1 && brownf > -1) || (purplei > -1 && purplef > -1) || (pinki > -1 && pinkf > -1) || (orangei > -1 && orangef > -1)) {
			if (redi > -1 && redf > -1) {
				int i = redi;
				int j = redf;
				System.out.println("Go to " + stations.get(init).getName() + " station.");
				while (i != j) {
					if(i < j)
						i++;
					else
						i--;
					for (Station s: stations) {
						if (s.getRed() == i)
							System.out.println("Then drive to" + s.getName() + " station.");
					}
				}
				System.out.println("You have arrived to " + stations.get(dest).getName() + " station.");
			} else if (greeni > -1 && greenf > -1) {
				int i = greeni;
				int j = greenf;
				System.out.println("Go to " + stations.get(init).getName() + " station.");
				while (i != j) {
					if(i < j)
						i++;
					else
						i--;
					for (Station s: stations) {
						if (s.getGreen() == i)
							System.out.println("Then drive to " + s.getName() + " station.");
					}
				}
				System.out.println("You have arrived to " + stations.get(dest).getName() + " station.");
			} else if (bluei > -1 && bluef > -1) {
				int i = bluei;
				int j = bluef;
				System.out.println("Go to " + stations.get(init).getName() + " station.");
				while (i != j) {
					if(i < j)
						i++;
					else
						i--;
					for (Station s: stations) {
						if (s.getBlue() == i)
							System.out.println("Then drive to " + s.getName() + " station.");
					}
				}
				System.out.println("You have arrived to " + stations.get(dest).getName() + " station.");
			} else if (browni > -1 && brownf > -1) {
				int i = browni;
				int j = brownf;
				System.out.println("Go to " + stations.get(init).getName() + " station.");
				while (i != j) {
					if(i < j)
						i++;
					else
						i--;
					for (Station s: stations) {
						if (s.getBrown() == i)
							System.out.println("Then drive to " + s.getName() + " station.");
					}
				}
				System.out.println("You have arrived to " + stations.get(dest).getName() + " station.");
			} else if (purplei > -1 && purplef > -1) {
				int i = purplei;
				int j = purplef;
				System.out.println("Go to " + stations.get(init).getName() + " station.");
				while (i != j) {
					if(i < j)
						i++;
					else
						i--;
					for (Station s: stations) {
						if (s.getPurple() == i)
							System.out.println("Then drive to " + s.getName() + " station.");
					}
				}
				System.out.println("You have arrived to " + stations.get(dest).getName() + " station.");
			} else if (pinki > -1 && pinkf > -1) {
				int i = pinki;
				int j = pinkf;
				System.out.println("Go to " + stations.get(init).getName() + " station.");
				while (i != j) {
					if(i < j)
						i++;
					else
						i--;
					for (Station s: stations) {
						if (s.getPink() == i)
							System.out.println("Then drive to " + s.getName() + " station.");
					}
				}
				System.out.println("You have arrived to " + stations.get(dest).getName() + " station.");
			} else if (orangei > -1 && orangef > -1) {
				int i = orangei;
				int j = orangef;
				System.out.println("Go to " + stations.get(init).getName() + " station.");
				while (i != j) {
					if(i < j)
						i++;
					else
						i--;
					for (Station s: stations) {
						if (s.getOrange() == i)
							System.out.println("Then drive to " + s.getName() + " station.");
					}
				}
				System.out.println("You have arrived to " + stations.get(dest).getName() + " station.");
			} else
				System.out.println("Take an Uber.");
		} else {
			Station clarklake = null;
			Station redgreen = null;
			Station redblue = null;
			Station redbrown = null;
			Station redpurple = null;
			Station redpink = null;
			Station redorange = null;
			for (Station station: stations) {
				if (station.getName().equalsIgnoreCase("Clark/Lake"))
					clarklake = station;
				if (station.getRed() > -1 && station.getGreen() > -1)
					redgreen = station;
				if (station.getRed() > -1 && station.getBlue() > -1)
					redblue = station;
				if (station.getRed() > -1 && station.getBrown() > -1)
					redbrown = station;
				if (station.getRed() > -1 && station.getPurple() > -1)
					redpurple = station;
				if (station.getRed() > -1 && station.getPink() > -1)
					redpink = station;
				if (station.getRed() > -1 && station.getOrange() > -1)
					redorange = station;
			}
			if (redi == -1 && redf == -1) {
				if (clarklake == null)
					System.out.println("Take an Uber.");
				else {
					route(init, clarklake.getId());
					System.out.println("Switch the lane.");
					route(clarklake.getId(), dest);
				}
			}
			else if(redi > -1 || greenf > -1) {
				if (redgreen == null)
					System.out.println("Take an Uber.");
				else {
					route(init, redgreen.getId());
					System.out.println("Switch the lane.");
					route(redgreen.getId(), dest);
				}
			} else if(redi > -1 || bluef > -1) {
				if (redblue == null)
					System.out.println("Take an Uber.");
				else {
					route(init, redblue.getId());
					System.out.println("Switch the lane.");
					route(redblue.getId(), dest);
				}
			} else if(redi > -1 || brownf > -1) {
				if (redbrown == null)
					System.out.println("Take an Uber.");
				else {
					route(init, redbrown.getId());
					System.out.println("Switch the lane.");
					route(redbrown.getId(), dest);
				}
			} else if(redi > -1 || purplef > -1) {
				if (redpurple == null)
					System.out.println("Take an Uber.");
				else {
					route(init, redpurple.getId());
					System.out.println("Switch the lane.");
					route(redpurple.getId(), dest);
				}
			} else if(redi > -1 || pinkf > -1) {
				if (redpink == null)
					System.out.println("Take an Uber.");
				else {
					route(init, redpink.getId());
					System.out.println("Switch the lane.");
					route(redpink.getId(), dest);
				}
			} else if(redi > -1 || orangef > -1) {
				if (redorange == null)
					System.out.println("Take an Uber.");
				else {
					route(init, redorange.getId());
					System.out.println("Switch the lane.");
					route(redorange.getId(), dest);
				}
			} else if(greeni > -1 || redf > -1) {
				if (redgreen == null)
					System.out.println("Take an Uber.");
				else {
					route(init, redgreen.getId());
					System.out.println("Switch the lane.");
					route(redgreen.getId(), dest);
				}
			} else if(bluei > -1 || redf > -1) {
				if (redblue == null)
					System.out.println("Take an Uber.");
				else {
					route(init, redblue.getId());
					System.out.println("Switch the lane.");
					route(redblue.getId(), dest);
				}
			} else if(browni > -1 || redf > -1) {
				if (redbrown == null)
					System.out.println("Take an Uber.");
				else {
					route(init, redbrown.getId());
					System.out.println("Switch the lane.");
					route(redbrown.getId(), dest);
				}
			} else if(purplei > -1 || redf > -1) {
				if (redpurple == null)
					System.out.println("Take an Uber.");
				else {
					route(init, redpurple.getId());
					System.out.println("Switch the lane.");
					route(redpurple.getId(), dest);
				}
			} else if(pinki > -1 || redf > -1) {
				if (redpink == null)
					System.out.println("Take an Uber.");
				else {
					route(init, redpink.getId());
					System.out.println("Switch the lane.");
					route(redpink.getId(), dest);
				}
			} else if(orangei > -1 || redf > -1) {
				if (redorange == null)
					System.out.println("Take an Uber.");
				else {
					route(init, redorange.getId());
					System.out.println("Switch the lane.");
					route(redorange.getId(), dest);
				}
			} else {
				System.out.println("No route found.");
			}
		}
	}
}
