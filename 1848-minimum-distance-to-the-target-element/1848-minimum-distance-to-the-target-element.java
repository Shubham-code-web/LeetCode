class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int arrayLength = nums.length;
        int minDistance = arrayLength;
        for (int currentIndex = 0; currentIndex < arrayLength; ++currentIndex) {
            if (nums[currentIndex] == target) {
                int currentDistance = Math.abs(currentIndex - start);
                minDistance = Math.min(minDistance, currentDistance);
            }
        }
        return minDistance;
    }
}
