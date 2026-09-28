class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        int n = nums.size();
        k = n - k;
        auto quickSelect = [&](auto&& quickSelect, int left, int right) -> int {
            if (left == right) {
                return nums[left];
            }
            int i = left - 1;
            int j = right + 1;
            int pivot = nums[(left + right) >> 1];
            while (i < j) {
                while (nums[++i] < pivot) {
                }
                while (nums[--j] > pivot) {
                }
                if (i < j) {
                    swap(nums[i], nums[j]);
                }
            }
            if (j < k) {
                return quickSelect(quickSelect, j + 1, right);
            }
            return quickSelect(quickSelect, left, j);
        };
        return quickSelect(quickSelect, 0, n - 1);
    }
};