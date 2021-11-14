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
		if (a.length == 0) { return -1;}
		else {
			if (a[0] == target) { return 0;}
			else {
				int[] aNew = new int[a.length-1];
        		        for (int i = 1; i < a.length; i++) {
                	        	aNew[i-1] = a[i];
               			}
				if ((a[1 + linSearchR(aNew, target)]) == target) {
					return 1 + linSearchR(aNew, target); }
				else { return -1; }
			}
		}
	}

	public static int freq(int[] a, int target) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == target) { count++; }
		}
		return count;
	}

	public static int freqRec(int[] a, int target) {
                int[] aNew = new int[a.length-1];
                for (int i = 1; i < a.length; i++) {
                        aNew[i-1] = a[i];
                }
		if (a.length == 0) { return 0; }
		else {
			if (a[0] == target) {
				if (aNew.length == 0) { return 1; }
				else { return 1 + freqRec(aNew, target); }
			}
			else {
				if (aNew.length == 0) { return 0; }
				else { return freqRec(aNew, target); }
			}
		}
	}

	public static void main(String[] args) {
		int[] array = new int[25];
		addInts(array);
		System.out.println(stringArray(array));
		System.out.println(linSearch(array,0));
		System.out.println(linSearchR(array,0));
		System.out.println(freq(array,0));
		System.out.println(freqRec(array,0));
	}

}
