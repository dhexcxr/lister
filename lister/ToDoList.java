package lister;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {

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
	public void setListItems(List<ListItem> listItems) {
		this.listItems = listItems;
	}
	
	public ToDoList(String listName) {
		setListName(listName);
		setListItems(new ArrayList<>());;
	}
}
