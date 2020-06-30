import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class PhysiciansHelper {
	// symptom to illnesses map
	private Map<String, List<String>> symptomChecker;

	/* Constructor symptomChecker map using TreeMap */
	public PhysiciansHelper() {
		// use TreeMap, i.e. sorted order keys
		symptomChecker = new TreeMap<String, List<String>>();
	} // end default constructor

	/*
	 * Reads a text file of illnesses and their symptoms. Each line in the file has
	 * the form Illness: Symptom, Symptom, Symptom, ... Store data into
	 * symptomChecker map
	 */

	public void processDatafile() {
		// Step 1: read in a data filename from keyboard
		// create a scanner for the file
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter data filename: ");
		String fileName = sc.next();
		System.out.println("\n\n============================================");
		File file = new File("PJ4_stud/" + fileName);
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("I/O error " + e.getMessage());
		}
		// Step 2: process data lines in file scanner
		// 2.1 for each line, split the line into a disease and symptoms
		// make sure to trim() spaces and use toLowercase()
		while (sc.hasNext()) {
			String line = sc.nextLine();
			String s[] = line.split(":|,");
			String disease = s[0].toLowerCase().trim();
			for (int i = 1; i < s.length; i++) {
				String symptom = s[i].toLowerCase().trim();
				if (symptomChecker.containsKey(symptom)) {
					symptomChecker.get(symptom).add(disease);
				} else {
					List<String> l = new ArrayList<String>();
					symptomChecker.put(symptom, l);
					l.add(disease);
				}
			}
		}

		// 2.2 for symptoms, split into individual symptom
		// create a scanner for symptoms
		// useDelimeter(",") to split into individual symptoms
		// make sure to trim() spaces and use toLowercase()
		// for each symptom

		// if it is already in the map, insert disease into related list
		// if it is not already in the map, create a new list with the disease
		// Step 3: display symptomChecker map

		// implement here.....
		System.out.println("symptomChecker map:");
		for (Entry<String, List<String>> e : symptomChecker.entrySet()) {
			System.out.println(e);
		}
		System.out.println("============================================");
	} // end processDatafile

	/*
	 * Read patient's symptoms in a line and adds them to the list. Input format:
	 * Symptom, Symptom, Symptom,... Shows diseases that match a given number of the
	 * symptoms.
	 */

	public void processSymptoms() {

		// Step 1: get all possible symptoms from symptomChecker map
		// and display them
		System.out.println("\nThe possible symptoms are:");
		for (String str : symptomChecker.keySet()) {
			System.out.println(str);
		}
		// Step 2: process patient symptoms, add to patientSymptoms list
		// read patient's symptoms in a line, separated by ','
		// create a scanner for symptoms
		// UseDelimeter(",") to split into individual symptoms
		// make sure to trim() spaces and use toLowercase()
		// display invalid/duplicate symptoms
		// add valid symptoms to patientSymptoms list
		Scanner sc = new Scanner(System.in);
		System.out.println("\n============================================\n");
		System.out.print("Enter symptoms: ");
		String arr[] = sc.nextLine().split(",");
		List<String> patientSymptoms = new ArrayList<String>();
		for (String symptom : arr) {
			symptom = symptom.toLowerCase().trim();
			if (!symptomChecker.containsKey(symptom)) {
				System.out.println("=>invalid symptom:" + symptom);
			} else if (patientSymptoms.contains(symptom)) {
				System.out.println("=>duplicate symptom:" + symptom);
			} else {
				patientSymptoms.add(symptom);
			}
		}
		// Step 3: display patientSymptoms list
		System.out.println("\n============================================\n");
		System.out.println("PatientSymptoms list: " + patientSymptoms);
		// Step 4: process illnesses to frequency count
		// create a map of disease name and frequency count
		// for each symptom in patientSymptoms list
		// get list of illnesses from symptomChecker map
		// for each illness in the list
		// if it is already in the map, increase counter by 1
		// if it is not already in the map, create a new counter 1
		// ** need to keep track of maximum counter numbers
		Map<String, Integer> frequencyMap = new TreeMap<String, Integer>();
		int maxFrequency = 0;
		for (String symptom : patientSymptoms) {
			List<String> illnesses = symptomChecker.get(symptom);
			for (String disease : illnesses) {
				if (frequencyMap.containsKey(disease)) {
					frequencyMap.put(disease, frequencyMap.get(disease) + 1);
				} else {
					frequencyMap.put(disease, 1);
				}
				if (frequencyMap.get(disease) > maxFrequency) {
					maxFrequency = frequencyMap.get(disease);
				}
			}
		}

		// Step 5: display result
		// for count i = 1 to maximum counter number
		// display illness that has count i

		// implement here.....
		if (!patientSymptoms.isEmpty()) {
			System.out.println("\nPossible illnesses that match any symptom are:");
		}
		for (int i = 1; i <= maxFrequency; i++) {
			System.out.println("\n==> Disease(s) match " + i + " symptom(s)");
			for (String disease : frequencyMap.keySet()) {
				if (frequencyMap.get(disease) == i) {
					System.out.println(disease);
				}
			}
		}
	} // end processSymptoms

	public static void main(String[] args) {

		PhysiciansHelper lookup = new PhysiciansHelper();
		lookup.processDatafile();
		lookup.processSymptoms();
	} // end main
} // end PhysiciansHelper
