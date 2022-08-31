package lister;

import java.util.Date;

public class ListItem {

	// TODO make serializable

	private String toDoItem;
	private Date creationDateTime;
	private boolean done;
	private Date finishedDateTime;

	public String getToDoItem() {
		return toDoItem;
	}

	public void setToDoItem(String toDoItem) {
		this.toDoItem = toDoItem;
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
		setToDoItem(toDoItem);
		setCreationDateTime(new Date(System.currentTimeMillis()));
		setDone(false);
		setFinishedDateTime(new Date());
	}
	
	

}
