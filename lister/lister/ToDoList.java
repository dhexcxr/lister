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
	}
	
	private boolean showListItems() {
		if (listItems.isEmpty()) {
			out.println("You have no To Do items on this list...\n");
			return false;
		}

		ListIterator<ListItem> listerIterator = listItems.listIterator();

		int i = 1;

		while (listerIterator.hasNext()) {
			out.println(i + ". " + listerIterator.next().toString());
		}

		out.println();
		return true;
	}

	@Override
	public String toString() {
		// TODO make better
		return listName + ", Created: " + getCreationDateTime();
	}
}
