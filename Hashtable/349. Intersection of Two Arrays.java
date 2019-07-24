class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1, set2;
        set1 = new HashSet<>();
        for (int num: nums1) {
            set1.add(num);
        }
        
        set2 = new HashSet<>();
        for (int num: nums2) {
            set2.add(num);
        }
        List<Integer> res = new ArrayList<>();
        for (int s: set1) {
            if (set2.contains(s)) {
                res.add(s);
            }
        }
        
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
