package dfs;

/**
 * LeetCode207. Course Schedule(https://leetcode.com/problems/course-schedule/description/)
 *
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed
 * as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 *
 * Solution: Build a directed graph from the prerequisites array. For example, [1,0] can be represented by matrix[0][1] == 1,
 * that is 0->1, means course1 is the "child" of course0, course1 depends on course0. We count the indegree of each course,
 * representing this course depends on how many precourses. If the indegree of course is 0, it does not depends on any other
 * course or all the courses it depends on have been finished. So we could add these courses whose indegree is 0 into a
 * queue. And iterate all the courses that depends on current course and decrease their indegrees, because this precourse
 * has been finished. At the end, check whether the number of course with zeor indegree is the same with number of total
 * courses.
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //directed graph
        int[][] edgeMatrix = new int[numCourses][numCourses];
        int[] indegrees = new int[numCourses];

        for (int i = 0; i < prerequisites.length; ++i) {
            int ready = prerequisites[i][0];
            int pre = prerequisites[i][1];
            //increase course indegree, means increase it's dependency courses number
            indegrees[ready]++;
            //mark ready course depends on precourse, like 0->1, course1 depends on course0
            edgeMatrix[pre][ready] = 1;
        }

        Queue<Integer> nodesWithNoEdge = new LinkedList<Integer>();
        for (int i = 0; i < indegrees.length; ++i) {
            if (indegrees[i] == 0) {
                //course which does not depend on other course
                nodesWithNoEdge.offer(i);
            }
        }

        int courseCount = 0;
        while(!nodesWithNoEdge.isEmpty()) {
            int course = nodesWithNoEdge.poll();
            courseCount++;

            for(int j = 0; j < edgeMatrix[0].length; ++j) {
                if (edgeMatrix[course][j] != 0) {
                    indegrees[j]--;
                    if (indegrees[j] == 0) {
                        //all the dependency courses have been finished, so could take current course
                        nodesWithNoEdge.offer(j);
                    }
                }
            }
        }
        return numCourses == courseCount;
    }
}