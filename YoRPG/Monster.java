public class Monster {

	public int hp;

	public Monster (){
		hp = (int)(Math.random()*100) + 10;
	}

	public boolean isAlive() {
		return (hp > 0);
	}

	public static int attack(Protagonist pat) {
		int damage = (int)(Math.random()*25)*pat.attackLevel;
		pat.hp = pat.hp - damage;
		return damage;
	}

}
