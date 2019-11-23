package org.yorha.array.findmediansortedarrays;

class Solution {

	private static int[] arr = {0, 0};

	private void add(int element) {
		arr[0] = arr[1];
		arr[1] = element;
	}


	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int p1 = 0, p2 = 0;
		for (int i = 0; i <= (nums1.length + nums2.length) / 2; i++) {
			if (p1 == nums1.length) {
				add(nums2[p2++]);
				continue;
			}
			if (p2 == nums2.length) {
				add(nums1[p1++]);
				continue;
			}
			if (nums1[p1] < nums2[p2]) {
				add(nums1[p1++]);
			} else {
				add(nums2[p2++]);
			}
		}
		if ((nums1.length + nums2.length) % 2 == 1) {
			return arr[1];
		} else {
			return (double) (arr[0] + arr[1]) / 2;
		}
	}

	public static void main(String[] args) {
		int a[] ={1,2};
		int b[] ={3,4};
		System.out.println(new Solution().findMedianSortedArrays(a,b));
	}

}
