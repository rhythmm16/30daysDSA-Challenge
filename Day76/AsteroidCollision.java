import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int a : asteroids) {
            boolean destroyed = false;
            while (!stack.isEmpty() && stack.peekLast() > 0 && a < 0) {
                if (stack.peekLast() < -a) {
                    stack.pollLast();
                    continue;
                } else if (stack.peekLast() == -a) {
                    stack.pollLast();
                }
                destroyed = true;
                break;
            }
            if (!destroyed) stack.addLast(a);
        }
        int[] res = new int[stack.size()];
        int i = 0;
        for (int val : stack) res[i++] = val;
        return res;
    }
}
