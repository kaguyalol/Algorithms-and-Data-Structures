class Solution {
    /**
     * [Reference](https://www.youtube.com/watch?v=ZmnqCZp9bBs)
     * Key points:
     *   Use stack to store idx of every bar that will be used for calculating
     *   areas;
     *    
     * Time Complexity: O(n). n is the length of input, up to two pass of input   
     * Space Complexity: O(n). Stack is used.
     */
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.offerFirst(0);
        int top = 0, maxArea = heights[0];
        for (int i = 1; i <= heights.length; i++) {
            while (!stack.isEmpty() && (i == heights.length ||
                   heights[i] <= heights[stack.peekFirst()])) {
                top = heights[stack.pollFirst()];
                if (stack.isEmpty())
                    maxArea = Math.max(maxArea, top * i);
                else
                    maxArea = Math.max(maxArea, top * 
                                       (i - stack.peekFirst() - 1));
            }
            stack.offerFirst(i);
        }
        return maxArea;
    }
}
