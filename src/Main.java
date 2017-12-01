import java.util.*;
import java.io.*;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.nio.charset.StandardCharsets; 
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.nio.file.Paths; 
import java.util.ArrayList; 
import java.util.List;

public class Main {
	static ArrayList<Character> characters = new ArrayList<>();
	static String fileName = "C:/Users/Slawek-Laptop/Desktop/College 17 slash 18/Databases 2/Assignment/game_of_thrones.js";
	static File basic_collection = new File("C:/Users/Slawek-Laptop/Desktop/College 17 slash 18/Databases 2/Assignment/basic.js");
	static File new_design_collection = new File("C:/Users/Slawek-Laptop/Desktop/College 17 slash 18/Databases 2/Assignment/redesigned.js");
	public static void main(String[] args) throws Exception{

		readCharacters("C:/Users/Slawek-Laptop/Desktop/College 17 slash 18/Databases 2/Assignment/character-deaths.csv");
		
//		for (Character c : characters){
//			System.out.println(c);
//		}
		saveCollection();
		saveNewCollection();
		
	}
	
	//reads all the characters from the csv file
	private static ArrayList<Character> readCharacters(String fileName) throws IOException{
		
		String line;
		
		BufferedReader br = Files.newBufferedReader(Paths.get(fileName),StandardCharsets.US_ASCII);
			
			br.readLine();
			while((line = br.readLine()) != null){
				String[] attributes = line.split(",");
				
				Character character = createCharacter(attributes);
				characters.add(character);
				
				line = br.readLine();
				
			} 
			br.close();
			
		return characters;	
		}
	
	//Saves the original collection in a js file, which can be run on mongodb
	private static void saveCollection() throws IOException{
		FileWriter fw = new FileWriter(basic_collection);
		BufferedWriter bw = new BufferedWriter(fw);
		StringBuilder sb = new StringBuilder();
		
		//adds first line
		String collection = "use GoT\n";
		bw.write(collection);

			for (int i = 0; i < characters.size() - 1; i++){
				Character c = characters.get(i);
				
				sb.append("db.CharacterDeaths.insert({"
						+ "_id:\""+c.getName() + 
						"\",allegiance:\""+c.getAllegiance() + 
						"\",death_year:" + c.getDeath_year() +
						",book_of_death:" + c.getBook_of_death() + 
						",death_chapter:" + c.getDeath_chapter() + 
						",book_intro:" + c.getBook_intro() +
						",gender:" + c.getGender() + 
						",nobility:" + c.getNobility() + 
						",got:" + c.getGot() + 
						",cok:" + c.getCok() + 
						",sos:" + c.getSos() +
						",ffs:" + c.getFfs() + 
						",dwd:" + c.getDwd() +"})\n");

				bw.write(sb.toString());

				System.out.println(sb.toString());
				sb.setLength(0);
			}
			bw.close();
	}
	
	//Saves my newly designed collection in a js file, which can be run on mongodb
	private static void saveNewCollection() throws IOException{
		FileWriter fw = new FileWriter(new_design_collection);
		BufferedWriter bw = new BufferedWriter(fw);
		StringBuilder sb = new StringBuilder();
		
		String collection = "use GoT\n";
		bw.write(collection);

		//iterates through all the Character objects in the characters arraylist
			for (int i = 0; i < characters.size() - 1; i++){
				Character c = characters.get(i);
				
				sb.append("db.CharacterDeaths.insert({"
						+ "_id:\""+c.getName() + 
						"\",allegiance:\"" + c.getAllegiance() + 
						"\",book_intro:" + c.getBook_intro() +
						",death_facts:[{"
							+"death_year:" + c.getDeath_year() +
							",book_of_death:" + c.getBook_of_death() + 
							",death_chapter:" + c.getDeath_chapter() + 
							"}]"
						+ ",gender:" + c.getGender() + 
						",nobility:" + c.getNobility() +
						",books:[{"
							+ "got:" + c.getGot() + 
							",cok:" + c.getCok() + 
							",sos:" + c.getSos() +
							",ffs:" + c.getFfs() + 
							",dwd:" + c.getDwd() +
							"}]"
							+ "})\n");

				bw.write(sb.toString());

				System.out.println(sb.toString());
				sb.setLength(0);
			}
			bw.close();
	}
	
	//creates objects of class Character for each person in the csv file
	private static Character createCharacter(String[] metadata) {
		
		int death_year,book_of_death,death_chapter,book_intro; //ints that need to be checked if they equal to 0
		String name = metadata[0];
		String allegiance= metadata[1];
		
		//I was going to implement a try/catch exception method to set the integers to 0
		//when the entry in the Integer row is empty
		if(metadata[2].equals("")){
			death_year = 0;
		}else{
		 death_year= Integer.parseInt(metadata[2]);}
		
		if(metadata[3].equals("")){
			book_of_death = 0;
		}else{ 
			book_of_death = Integer.parseInt(metadata[3]);
		}
		
		if(metadata[4].equals(""))
		{
			death_chapter = 0;
		}else{
			death_chapter = Integer.parseInt(metadata[4]);
		}
		
		if(metadata[5].equals(""))
		{
			book_intro = 0;
		}else{
			book_intro = Integer.parseInt(metadata[5]);
		}
		
		int gender = Integer.parseInt(metadata[6]);
		int nobility = Integer.parseInt(metadata[7]);
		int got = Integer.parseInt(metadata[8]);
		int cok = Integer.parseInt(metadata[9]);
		int sos = Integer.parseInt(metadata[10]);
		int ffs = Integer.parseInt(metadata[11]);
		int dwd = Integer.parseInt(metadata[12]);

		return new Character (name, allegiance, death_year, book_of_death, death_chapter, book_intro , gender, nobility, got, cok, sos, ffs, dwd);

		}
		
}

