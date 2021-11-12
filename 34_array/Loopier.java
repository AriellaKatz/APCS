public class Loopier {

	public static void addInts (int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] =(int)(Math.random() * 100);
		}
	}

	public static String stringArray(int[] array) {
		String ans = "";
		for (int i = 0; i < array.length; i++) {
			ans += array[i] + ", ";
		}
		return ans.substring(0,ans.length()-2);
	}

	public static int linSearch(int[] a, int target) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == target) { return i; }
		}
		return -1;
	}

	public static int linSearchR(int[] a, int target) {
		int i
	}

	public static void main(String[] args) {
		int[] array = new int[10];
		addInts(array);
		System.out.println(stringArray(array));
		System.out.println(linSearch(array,0));
	}

}
