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
			String mainMenuSelection = showMainMenu();
			
			out.println();

			switch (mainMenuSelection) {
			case "1": {
				listLists();
				break;
			}
			case "2": {
				createList();
				break;
			}
			case "3": {
				deleteList();
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
				out.println("Invalid selection: " + mainMenuSelection + "\n\n");
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

	private static boolean listLists() {
		if (listerLists.isEmpty()) {
			out.println("You have no lists...\n");
			return false;
		}

		ListIterator<ToDoList> listerIterator = listerLists.listIterator();

		int i = 1;
		
		while (listerIterator.hasNext()) {
			out.println(i + ". " + listerIterator.next().toString());
		}
		
		out.println();
		return true;
	}
	
	private static void createList() {
		out.print("What would you like to name the new Lister list? ");
		String newListName = keyboard.nextLine();
		listerLists.add(new ToDoList(newListName));
		// TODO test for sucsessful list creation
		out.println("New list created...");		// TODO include list name
	}
	
	private static void deleteList() {
		if(listLists()) {
			out.print("Which list would you like to remove? ");
			String listIndexInput = keyboard.nextLine();
			
			int listIndex = Integer.parseInt(listIndexInput);
			
			ListIterator<ToDoList> deleteIterator = listerLists.listIterator(listIndex);
			ToDoList listToDelete = deleteIterator.next();
			
			while (true) {
				out.print("Delete list: " + listToDelete.toString() + "? [Y/N] ");
				String deleteConfirmation = keyboard.nextLine();
				
				switch (deleteConfirmation.toUpperCase()) {
				case "Y": {
					deleteIterator.remove();
					// TODO confirm deletion
					out.println(listToDelete.toString() + " deleted...");
					return;
				}
				case "N": {
					out.println(listToDelete.toString() + " not deleted...");
					return;
				}
				default:
					out.println("Invalid selection: " + deleteConfirmation + "\n\n");
				}
			}
			
		}
		
	}
}