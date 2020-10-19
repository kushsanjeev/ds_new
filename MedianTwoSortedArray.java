/*

Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

Follow up: The overall run time complexity should be O(log (m+n)).

 

Example 1:

	Input: nums1 = [1,3], nums2 = [2]
	Output: 2.00000
	Explanation: merged array = [1,2,3] and median is 2.

*/

class MedianTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       int[] m = merge(nums1,nums2);
       double median; 
       int len = m.length;
        if(len%2==1){
            median = m[len/2];
            return median;
        }
        else{
            median = (m[len/2]+m[(len/2)-1])/2.0;
            return median;
        }
    }
    
    public int[] merge(int[] nums1,int[] nums2){
        int[] t = new int[nums1.length+nums2.length];
        int c1=0,c2=0;
        while(c1<nums1.length && c2<nums2.length){
            if(nums1[c1]>nums2[c2]){
                t[c1+c2] = nums2[c2];
                c2++;
                continue;
            }
            else{
               t[c1+c2] = nums1[c1];
                c1++;
                continue; 
            }
        }
        while(c1<nums1.length){
            t[c1+c2] = nums1[c1];
            c1++;
            }
         while(c2<nums2.length){
            t[c1+c2] = nums2[c2];
            c2++;
            }
        return t;
    }
}

int main(){
	int arr1[] = {1,2,3,4,5,6};
	int arr2[] = {6,7,8,9,10};
	MedianTwoSortedArray obj;
	obj.findMedianSortedArrays(arr1,arr2);
}
