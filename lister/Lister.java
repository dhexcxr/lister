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
		
		out.println("Welcome to Lister");

		while (true) {
			String mainMeduSelection = showMainMenu();
			
			out.println();

			switch (mainMeduSelection) {
			case "1": {
				listLists();
				break;
			}
			case "2": {
				createList();
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

	private static String showMainMenu() {
		out.println("1. List Lister lists");
		out.println("2. Create Lister list");
		out.println("3. Delete Lister list");
		out.println("4. Open Lister list");
		out.println("5. Quit Lister");
		out.print("\nMake a selection: ");

		return keyboard.nextLine();
	}

	private static void listLists() {
		if (listerLists.isEmpty()) {
			out.println("You have no lists...\n");
			return;
		}

		ListIterator<ToDoList> listerIterator = listerLists.listIterator();

		while (listerIterator.hasNext()) {
			out.println(listerIterator.next().toString());
		}
		
		out.println();
	}
	
	private static void createList() {
		out.print("What would you like to name the new Lister list? ");
		String newListName = keyboard.nextLine();
		listerLists.add(new ToDoList(newListName));
		// TODO test for sucsessful list creation
		out.println("New list created...");		// TODO include list name
	}
}
