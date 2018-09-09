package string;

/**
 * LeetCode657. Robot Return to Origin(https://leetcode.com/problems/robot-return-to-origin/description/)
 *
 * There is a robot starting at position (0, 0), the origin, on a 2D plane. Given a sequence of its moves, judge if this
 * robot ends up at (0, 0) after it completes its moves.
 * The move sequence is represented by a string, and the character moves[i] represents its ith move. Valid moves are R (right),
 * L (left), U (up), and D (down). If the robot returns to the origin after it finishes all of its moves, return true. Otherwise,
 * return false.
 *
 * Solution: Just check whether the steps of up and down are equal, and the steps of left and right are equal.
 */
public class RobotReturnToOrigin {
    public boolean judgeCircle(String moves) {
        int ups = 0, lefts=0;
        if (moves.length() % 2 != 0) {
            return false;
        }
        for (int i = 0; i < moves.length(); ++i) {
            char move = moves.charAt(i);
            if (move == 'U') {
                ups++;
            } else if (move == 'D') {
                ups--;
            } else if (move == 'L') {
                lefts++;
            } else {
                lefts--;
            }
        }
        return ups == 0 && lefts == 0;
    }
}