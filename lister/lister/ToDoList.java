package lister;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class ToDoList {

	private static Scanner keyboard = new Scanner(System.in);

	// TODO make serializable

	private String listName;
	private Date creationDateTime;
	private List<ListItem> listItems;

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public Date getCreationDateTime() {
		return creationDateTime;
	}

	public void setCreationDateTime(Date creationDateTime) {
		this.creationDateTime = creationDateTime;
	}

	public List<ListItem> getListItems() {
		return listItems;
	}

	public void setListItems(List<ListItem> listItems) {
		this.listItems = listItems;
	}

	public void addNewListItem() {
		out.print("What would you like to name the new Lister To Do item? ");
		String newToDoItemName = keyboard.nextLine();
		listItems.add(new ListItem(newToDoItemName));
	}

	public ToDoList(String listName) {
		setListName(listName);
		setCreationDateTime(new Date(System.currentTimeMillis()));
		setListItems(new ArrayList<>());
	}

	public void openList() {
		// TODO print menu of List Options
//		showListItems();

		while (true) {
			out.println("Current list:\n" + this.toString());
			String listMenuSelection = showListMenu();

			out.println();

			switch (listMenuSelection) {
			case "1": {
				showListItems();
				break;
			}
			case "2": {
				createListItem();
				break;
			}
			case "3": {
				deleteListItem();
				break;
			}
			case "4": {
				//			openList();
				break;
			}
			case "5": {
				//			out.println("Good bye...");
				return;
			}
			default:
				out.println("Invalid selection: " + listMenuSelection + "\n\n");
			}
		}
	}
	
	private static String showListMenu() {
		out.println("List Menu");
		out.println("1. List To Do items");
		out.println("2. Create To Do item");
		out.println("3. Delete To Do item");
		out.println("4. Check off To Do item");
		out.println("5. Close list");
		out.print("\nMake a selection: ");

		return keyboard.nextLine();
	}
	
	private boolean showListItems() {
		if (listItems.isEmpty()) {
			out.println("You have no To Do items on this list...\n");
			return false;
		}

		out.println("Current Items on list:");
		ListIterator<ListItem> listerIterator = listItems.listIterator();
		int i = 1;
		while (listerIterator.hasNext()) {
			out.println(i + ". " + listerIterator.next().toString());
		}

		out.println();
		return true;
	}
	
	private void createListItem() {
		// TODO create a new To Do list item
		out.print("What would you like to name the new To Do item? ");
		String newListItemName = keyboard.nextLine();
		listItems.add(new ListItem(newListItemName));
		// TODO test for successful ToDo Item creation
		out.println("New To Do item created...\n"); // TODO include To Do item name
	}
	
	private void deleteListItem() {
		// TODO delete a list item
		if (showListItems()) {
			out.print("Which list would you like to remove? ");
			String toDoItemIndexInput = keyboard.nextLine();

			int toDoItemIndex = Integer.parseInt(toDoItemIndexInput);

			ListIterator<ListItem> deleteIterator = listItems.listIterator(toDoItemIndex);
			ListItem listItemToDelete = deleteIterator.previous();
			
			if (listItemToDelete.isDone()) {
				out.println("Cannot delete a completed To Do List item...");
				return;
			}

			while (true) {
				out.print("Delete list: " + listItemToDelete.toString() + "? [Y/N] ");
				String deleteConfirmation = keyboard.nextLine();

				switch (deleteConfirmation.toUpperCase()) {
				case "Y": {
					deleteIterator.remove();
					// TODO confirm deletion
					out.println(listItemToDelete.toString() + " deleted...\n");
					return;
				}
				case "N": {
					out.println(listItemToDelete.toString() + " not deleted...\n");
					return;
				}
				default:
					out.println("Invalid selection: " + deleteConfirmation + "\n\n");
				}
			}
		}
	}
	
	private void checkOffListItem() {
		// TODO mark a list item as Done
	}


	@Override
	public String toString() {
		// TODO make better
		return listName + ", Created: " + getCreationDateTime();
	}
}
