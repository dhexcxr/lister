package lister;

import java.util.Date;

public class ListItem {

	// TODO make serializable

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
		return creationDateTime;
	}

	public void setCreationDateTime(Date creationDateTime) {
		this.creationDateTime = creationDateTime;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
		setFinishedDateTime(new Date(System.currentTimeMillis()));
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
