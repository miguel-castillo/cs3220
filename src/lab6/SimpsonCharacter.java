package lab6;

public class SimpsonCharacter {
	
	private static int seed = 0;
	int id;
	String characterName;
	int numberOfPictures;

	public SimpsonCharacter(String characterName, int numberOfPictures) {
		this.characterName = characterName;
		this.numberOfPictures = numberOfPictures;
		id = seed;
		seed++;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	public int getNumberOfPictures() {
		return numberOfPictures;
	}

	public void setNumberOfPictures(int numberOfPictures) {
		this.numberOfPictures = numberOfPictures;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
