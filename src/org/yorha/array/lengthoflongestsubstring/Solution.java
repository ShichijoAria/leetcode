package org.yorha.array.lengthoflongestsubstring;

class Solution {

	public boolean isRepetitive(char[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					return true;
				}
			}
		}
		return false;
	}

	public char[] getQueue(char[] arr, int i, int j) {
		char[] queue = new char[j - i];
		for (int k = i; k < j; k++) {
			queue[k - i] = arr[k];
		}
		return queue;
	}

	public int lengthOfLongestSubstring(String s) {
		if (s.length() < 2) {
			return s.length();
		}
		char[] arr = s.toCharArray();
		if (s.length() == 2) {
			if (s.charAt(0) != s.charAt(1)) {
				return 2;
			}
			return 1;
		}
		int n = 1;
		for (int i = 2; i <= arr.length; i++) {
			char[] queue;
			boolean flag = true;
			for (int j = i; j <= arr.length; j++) {
				queue = this.getQueue(arr, j - i, j);
				if (!isRepetitive(queue)) {
					flag = false;
					break;
				}
			}
			if (!flag) {
				n += 1;
				continue;
			}
			return n;
		}
		return n;
	}

}