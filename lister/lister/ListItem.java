package lister;

import java.io.Serializable;
import java.util.Date;

public class ListItem implements Serializable {

	// TODO make serializable
	private static final long serialVersionUID = 3103112339987530571L;
	
	private String listItemName;
	private Date creationDateTime;
	private boolean done;
	private Date finishedDateTime;

	public String getListItemName() {
		return listItemName;
	}

	public void setListItemName(String toDoItem) {
		this.listItemName = toDoItem;
	}

	public Date getCreationDateTime() {
		return new Date(creationDateTime.getTime());
	}

	public void setCreationDateTime(Date creationDateTime) {
		this.creationDateTime = new Date(creationDateTime.getTime());
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public Date getFinishedDateTime() {
		return finishedDateTime;
	}

	public void setFinishedDateTime(Date finishedDateTime) {
		this.finishedDateTime = finishedDateTime;
	}

	public ListItem(String toDoItem) {
		setListItemName(toDoItem);
		setCreationDateTime(new Date(System.currentTimeMillis()));
		setDone(false);
		setFinishedDateTime(new Date());
	}
	
	public void checkOffListItem() {
		setDone(true);
		setFinishedDateTime(new Date(System.currentTimeMillis()));
	}

	@Override
	public String toString() {
		StringBuilder listDetails = new StringBuilder(
				"ListItem [toDoItem=" + listItemName + ", creationDateTime=" + creationDateTime + ", done=" + done + "]");
		if (isDone()) {
			listDetails.append(" " + getFinishedDateTime());
		}
		return listDetails.toString();
	}

}
