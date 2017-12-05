package example;

public class LinkEntry {
	
	String title, link;
	int id, vote = 0;
	
	public LinkEntry (int id, String title, String link, int vote){
		this.id = id;
		this.title = title;
		this.link = link;
		this.vote = vote;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVote() {
		return vote;
	}

	public void setVotes(int vote) {
		this.vote = vote;
	}
	
	
	
}
