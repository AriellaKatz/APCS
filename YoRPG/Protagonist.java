public class Protagonist {

	public String name;
	public int hp;
	public int attackLevel;

	public Protagonist(String inName) {
		name = inName;
		hp = 100;
	}

	public String getName() {
		return name;
	}

	public  boolean isAlive() {
		return (hp > 0);
	}

	public void specialize() {
		attackLevel = 2;
	}

	public void  normalize() {
		attackLevel = 1;
	}

	public int attack(Monster smaug) {
		smaug.hp = smaug.hp - (int)(Math.random()*50)*attackLevel;
	}

}
