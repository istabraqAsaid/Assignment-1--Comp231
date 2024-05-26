import java.util.Scanner;

public class Assignment {
	final static int f = 9;
    final static int p=4;
    final static int c=4;
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int personID = 0;
		int age = 0;
		int carbohydrates = 0;
		int fat = 0;
		int protein = 0;
		int counter = 0;
		double avgGrams = 0;
		double avgCalories = 0;
		int totalG = 0;
		int totalC = 0;
		double max = 0;
		int maxId = 0;
		int maxAge = 0;
		double energy = 0;
		while (true) {
			// It keeps entering users and stops if you enter -1
			System.out.println("please enter the ID person or -1 to end:");
			personID = input.nextInt();
			if (personID == -1)
				break;
			// It keeps entering age and stops if you enter -1
			System.out.println("please enter the age or -1 to end :");
			age = input.nextInt();
			if (age == -1)
				break;
			// It keeps entering carbohydrates and stops if you enter -1
			System.out.println("please enter the carbohydrates or -1 to end:");
			carbohydrates = input.nextInt();
			if (carbohydrates == -1)
				break;
			// It keeps entering fat and stops if you enter -1
			System.out.println("please enter the fat or -1 to end:");
			fat = input.nextInt();
			if (fat == -1)
				break;
			// It keeps entering protein and stops if you enter -1
			System.out.println("please enter the protein or -1 to end:");
			protein = input.nextInt();
			if (protein == -1)
				break;
			System.out.println("-------------------------------------------------------------------");
			// call the method Total Grams Which will collect proteins, fats and
			// carbohydrates for a person
			totalG = totalGrams(carbohydrates, fat, protein);
			System.out.println("Total Grams :" + totalG);
			// call the method Total Calories Which will collect proteins, fats and
			// carbohydrates for a person
			totalC = totalCalories(carbohydrates, fat, protein);
			System.out.println("Total Calories :" + totalC);

			System.out.println("-------------------------------------------------------------------");

			System.out.println("Percent of calories from each macronutrient:");
			// call to method percent Of Calories which will collect proteins, fats and
			// carbohydrates andDivide by their sum and multiply by 100% to convert to a
			// percentage
			double percent = percentOfCalories(carbohydrates, fat, protein);
			// call to method Energy Ratio
			energy = energyProteins(carbohydrates, fat, protein);
			System.out.printf("The Energy Ratio:%.1f \n", energy);
			System.out.println("-------------------------------------------------------------------");
			// Every time a user enters, the counter increases by one
			counter = +personID;
			// Comparison between users with the highest energy percentage between them and
			// return to me any higher energy percentage with how old and id
			if (energy > max) {
				max = energy;
				maxId = personID;
				maxAge = age;
			}

		}

		System.out.println("--------------------------------------------------");
		// Total grams of all users and divide it by the counter
		avgGrams = totalG / counter;
		System.out.println("The Avarege Grams:" + avgGrams);
		// Total Calories of all users and divide it by the counter
		avgCalories = totalC / counter;
		System.out.println("The Avarege Calories:" + avgCalories);
		System.out.println("--------------------------------------------------");
		System.out.println("Person Id:" + maxId + "Max age:" + maxAge + " are maximum");

	}

	// method Total Grams
	public static int totalGrams(int carbohydratess, int fats, int proteins) {

		int result = carbohydratess + fats + proteins;

		return result;
	}

	// method Total Calories return value in the call method in main
	public static int totalCalories(int carbohydratess, int fats, int proteins) {

		int totalCarbohydratess = carbohydratess *c ;
		int totalFat = fats * f;
		int totalproteins = proteins * p;

		int total = totalCarbohydratess + totalFat + totalproteins;

		return total;

	}

	// method percent Of Calories
	public static double percentOfCalories(int carbohydratess, int fats, int proteins) {
		double totalCarbohydratess = carbohydratess * c;
		double percentCarbohydratess = (double) (totalCarbohydratess / totalCalories(carbohydratess, fats, proteins))
				* 100;
		System.out.printf("Carbohydrate:%.1f %% \n", percentCarbohydratess);

		double totalFat = fats * f;
		double percentFat = (double) (totalFat / totalCalories(carbohydratess, fats, proteins)) * 100;
		System.out.printf("Fat :%.1f %% \n", percentFat);

		double totalproteins = proteins * p;
		double percentProteins = (double) (totalproteins / totalCalories(carbohydratess, fats, proteins)) * 100;
		System.out.printf("proteins:%.1f %% \n ", percentProteins);

		return 0;
	}

	// method energy proteins r.eturn value in the call method the main
	public static double energyProteins(int carbohydratess, int fats, int proteins) {
		double energy = (double) proteins / (fats + carbohydratess);
		return energy;
	}

}
