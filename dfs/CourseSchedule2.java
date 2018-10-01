package dfs;

/**
 * LeetCode210. Course Schedule II(https://leetcode.com/problems/course-schedule-ii/description/)
 *
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
 *
 * Solution: The basic idea is the same with leetcode 207, build a directed graph from the course dependency. Iterate the
 * courses, when the course's indegree is 0, add to the queue, so we could poll the course from the queue in order. At
 * the end, need to check whether we could take all the course by checking the course we have taken is the same with
 * the total number of the courses.
 */
public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //directed graph
        int[][] edgeMap = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];
        int[] result = new int[numCourses];

        for (int i = 0; i < prerequisites.length; ++i) {
            int ready = prerequisites[i][0];
            int pre = prerequisites[i][1];
            indegree[ready]++;
            edgeMap[pre][ready] = 1;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; ++i) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            result[count++] = course;

            for (int i = 0; i < edgeMap[0].length; ++i) {
                if (edgeMap[course][i] != 0) {
                    indegree[i]--;
                    if (indegree[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }

        //whether have taken all the courses
        return count == numCourses ? result : new int[0];
    }
}