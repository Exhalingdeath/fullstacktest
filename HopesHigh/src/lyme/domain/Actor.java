package lyme.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Actor {

	@Id
	private int actorId;
	private String actorFirstName;
	private String actorLastName;
	
	
	public int getActorId() {
		return actorId;
	}
	public void setActorId(int actorId) {
		this.actorId = actorId;
	}
	public String getActorFirstName() {
		return actorFirstName;
	}
	public void setActorFirstName(String actorFirstName) {
		this.actorFirstName = actorFirstName;
	}
	public String getActorLastName() {
		return actorLastName;
	}
	public void setActorLastName(String actorLastName) {
		this.actorLastName = actorLastName;
	}
	
}
