/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1, right = n;
        
        while (left <= right) {
            int mid = left + (right - left) / 2; // avoid overflow
            
            int res = guess(mid);
            if (res == 0) {
                return mid; // found the number
            } else if (res < 0) {
                right = mid - 1; // our guess is too high
            } else {
                left = mid + 1; // our guess is too low
            }
        }
        return -1; // not found (shouldn’t happen per problem constraints)
    }
}
