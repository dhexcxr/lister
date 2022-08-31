package lister;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import static java.lang.System.out;

public class Lister {

	private static Scanner keyboard = new Scanner(System.in);

	private static List<ToDoList> listerLists;

	public static void main(String[] args) {

		// TODO check for serialized lists
			// populate listerLists if present
			// make new list if not present
		if (listerLists == null) {
			listerLists = new ArrayList<>();
		}

		while (true) {
			String mainMeduSelection = showMenu();

			switch (mainMeduSelection) {
			case "1": {
				listLists();
				break;
			}
			case "2": {

				break;
			}
			case "3": {

				break;
			}
			case "4": {

				break;
			}
			case "5": {
				out.println("Good bye...");
				return;
			}
			default:
				out.println("Invalid selection: " + mainMeduSelection + "\n\n");
			}
		}

	}

	private static String showMenu() {
		out.println("Welcome to Lister");
		out.println("1. List Lister lists");
		out.println("2. Create Lister list");
		out.println("3. Delete Lister lists");
		out.println("4. Open Lister lists");
		out.println("5. Quit Lister");
		out.println("\nMake a selection: ");

		return keyboard.nextLine();
	}

	private static void listLists() {
		if (listerLists.isEmpty()) {
			out.println("You have no lists...");
			return;
		}

		ListIterator<ToDoList> listerIterator = listerLists.listIterator();

		while (listerIterator.hasNext()) {
			out.println(listerIterator.next().toString());
		}
	}
}
