package lister;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoList {
	
	private static Scanner keyboard = new Scanner(System.in);
	
	// TODO make serializable

	private String listName;
	private List<ListItem> listItems;
	
	public String getListName() {
		return listName;
	}
	
	public void setListName(String listName) {
		this.listName = listName;
	}
	
	public List<ListItem> getListItems() {
		return listItems;
	}
	
	public void showListItems() {
		// TODO print list items
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
		setListItems(new ArrayList<>());
	}
	
	public void openList() {
		// TODO print menu of List Options
	}
	
	@Override
	public String toString() {
		// TODO make better
		return "ToDoList [listName=" + listName + "]";
	}
}
