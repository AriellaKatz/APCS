public class Array2{

/*
Return the number of even ints in the given array. Note: the % "mod" operator computes the remainder, e.g. 5 % 2 is 1.

countEvens([2, 1, 2, 3, 4]) → 3
countEvens([2, 2, 0]) → 3
countEvens([1, 3, 5]) → 0
*/
	public int countEvens(int[] nums) {
		int counter = 0;
		for (int i  = 0; i < nums.length; i++) {
			if (nums[i] % 2 == 0) { counter++; }
		}
		return counter;
	}

/*
Given an array length 1 or more of ints, return the difference between the largest and smallest values in the array. Note: the built-in Math.min(v1, v2) and Math.max(v1, v2) methods return the smaller or larger of two values.

bigDiff([10, 3, 5, 6]) → 7
bigDiff([7, 2, 10, 9]) → 8
bigDiff([2, 10, 7, 2]) → 8
*/
	public int bigDiff(int[] nums) {
		int min = nums[0];
		int max = nums[0];
		for (int i = 0; i < nums.length - 1; i++) {
			int newMin = Math.min(nums[i], nums[i + 1]);
			int newMax = Math.max(nums[i], nums[i + 1]);
			if (newMin <= min) { min = newMin; }
			if (newMax >= max) { max = newMax; }
		}
		return (max - min);
	}

/*
Return the "centered" average of an array of ints, which we'll say is the
mean average of the values, except ignoring the largest and smallest values
in the array. If there are multiple copies of the smallest value, ignore
just one copy, and likewise for the largest value. Use int division to
produce the final average. You may assume that the array is length 3 or more.

centeredAverage([1, 2, 3, 4, 100]) → 3
centeredAverage([1, 1, 5, 5, 10, 8, 7]) → 5
centeredAverage([-10, -4, -2, -4, -2, 0]) → -3
*/
	public int centeredAverage(int[] nums) {
		int min = nums[0];
                int max = nums[0];
                for (int i = 0; i < nums.length - 1; i++) {
                        int newMin = Math.min(nums[i], nums[i + 1]);
                        int newMax = Math.max(nums[i], nums[i + 1]);
                        if (newMin <= min) { min = newMin; }
                        if (newMax >= max) { max = newMax; }
                }
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		return ((sum - min - max) / (nums.length - 2));
	}

	public static void main(String[] args) {
		Array2 test = new Array2();
		System.out.println(test.countEvens(new int[] {2, 1, 2, 3, 4}));
		System.out.println(test.countEvens(new int[] {2, 2, 0}));
		System.out.println(test.countEvens(new int[] {1, 3, 5}));
		System.out.println(test.bigDiff(new int[] {10, 3, 5, 6}));
                System.out.println(test.bigDiff(new int[] {7, 2, 10, 9}));
                System.out.println(test.bigDiff(new int[] {2, 10, 7, 2}));
		System.out.println(test.centeredAverage(new int[] {1, 2, 3, 4, 100}));
                System.out.println(test.centeredAverage(new int[] {1, 1, 5, 5, 10, 8, 7}));
                System.out.println(test.centeredAverage(new int[] {-10, -4, -2, -4, -2, 0}));
	}

}
