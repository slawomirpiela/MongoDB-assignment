
public class Character {
	
	private String name;
	private String allegiance;
	private int death_year;
	private int book_of_death;
	private int death_chapter;
	private int book_intro;
	private int gender;
	private int nobility;
	private int got;
	private int cok;
	private int sos;
	private int ffs;
	private int dwd;
	
	public int getBook_intro() {
		return book_intro;
	}
	public void setBook_intro(int book_intro) {
		this.book_intro = book_intro;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getNobility() {
		return nobility;
	}
	public void setNobility(int nobility) {
		this.nobility = nobility;
	}
	public int getGot() {
		return got;
	}
	public void setGot(int got) {
		this.got = got;
	}
	public int getCok() {
		return cok;
	}
	public void setCok(int cok) {
		this.cok = cok;
	}
	public int getSos() {
		return sos;
	}
	public void setSos(int sos) {
		this.sos = sos;
	}
	public int getFfs() {
		return ffs;
	}
	public void setFfs(int ffs) {
		this.ffs = ffs;
	}
	public int getDwd() {
		return dwd;
	}
	public void setDwd(int dwd) {
		this.dwd = dwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAllegiance() {
		return allegiance;
	}
	public void setAllegiance(String allegiance) {
		this.allegiance = allegiance;
	}
	public int getDeath_year() {
		return death_year;
	}
	public void setDeath_year(int death_year) {
		this.death_year = death_year;
	}
	public int getBook_of_death() {
		return book_of_death;
	}
	public void setBook_of_death(int book_of_death) {
		this.book_of_death = book_of_death;
	}
	public int getDeath_chapter() {
		return death_chapter;
	}
	public void setDeath_chapter(int death_chapter) {
		this.death_chapter = death_chapter;
	}

	public Character(String name, String allegiance, int death_year, int book_of_death, int death_chapter,
			int book_intro, int gender, int nobility, int got, int cok, int sos, int ffs, int dwd) {
		super();
		this.name = name;
		this.allegiance = allegiance;
		this.death_year = death_year;
		this.book_of_death = book_of_death;
		this.death_chapter = death_chapter;
		this.book_intro = book_intro;
		this.gender = gender;
		this.nobility = nobility;
		this.got = got;
		this.cok = cok;
		this.sos = sos;
		this.ffs = ffs;
		this.dwd = dwd;
	}

	
}
