public class Monster {

	public int hp;

	public Monster{
		hp = (int)(Math.random()*100) + 10
	}

	public boolean isAlive() {
		return (hp > 0);
	}

	public static int attack(Protagonist pat) {
		pat.hp = pat.hp - (int)(Math.random()*25)*pat.attackLevel;
	}

}
