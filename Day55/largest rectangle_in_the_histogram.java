class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int maxArea=0;
        Stack<Integer> st=new Stack<>();
         st.push(0);
        for(int i=0;i<=n;i++){
        int currHeight = (i == n) ? 0 : heights[i];

            
                while(!st.isEmpty() && currHeight<heights[st.peek()]){
                    int h=heights[st.pop()];
                    int width=0;
                    if(st.isEmpty()){
                        width=i;
                    }
                    else {
                    width = i - st.peek() - 1;
                }
                    int area = h * width;
                if (area > maxArea) {
                    maxArea = area;
                }
                }
                st.push(i);
            
        }
        return maxArea;
    }
}
