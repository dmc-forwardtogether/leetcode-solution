package leetcode.editor.cn;

//你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。 
//
// 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表
//示如果要学习课程 ai 则 必须 先学习课程 bi 。 
//
// 
// 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。 
// 
//
// 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：true
//解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。 
//
// 示例 2： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
//输出：false
//解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。 
//
// 
//
// 提示： 
//
// 
// 1 <= numCourses <= 105 
// 0 <= prerequisites.length <= 5000 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// prerequisites[i] 中的所有课程对 互不相同 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 
// 👍 884 👎 0

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseSchedule {
    public static void main(String[] args) {
        /*
        样例1
        课程总数：2
        先修课程关系数：1
        关系：
        1 0
        
        样例2
        课程总数：2
        先修课程关系数：2
        关系：
        1 0
        0 1
        
        样例3
        课程总数：7
        先修课程关系数：8
        关系：
        1 2
        0 2
        0 4
        0 5
        5 4
        3 5
        5 6
         */
        Solution solution = new CourseSchedule().new Solution();
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入总课程数:");
        int numCourses = scanner.nextInt();
        System.out.print("输入先修课程关系数:");
        int numPrerequisites = scanner.nextInt();
        int[][] prerequisites = new int[numPrerequisites][2];
        System.out.print("输入先修课程关系:");
        for (int i = 0; i < numPrerequisites; i++) {
            prerequisites[i][0] = scanner.nextInt();
            prerequisites[i][1] = scanner.nextInt();
        }
        System.out.println(solution.canFinish(numCourses, prerequisites));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //访问标记
        int[] visited;
        //结果
        boolean finishFlag = true;
        //节点图
        List<List<Integer>> edges;

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            edges = new ArrayList<>();
            //初始化图的节点联系
            for (int i = 0; i < numCourses; ++i) {
                edges.add(new ArrayList<>());
            }
            //建立一个存放访问标记的数组（栈），0代表未访问，1代表已访问，2表示此节点出发的节点不会成环
            visited = new int[numCourses];
            //每个节点带有一个子链来表示先后关系
            for (int[] prerequisite : prerequisites) {
                edges.get(prerequisite[1]).add(prerequisite[0]);
            }

            //在结果为真时，对未访问过的节点进行访问
            for (int i = 0; i < numCourses && finishFlag; ++i) {
                if (visited[i] == 0) {
                    dfs(i);
                }
            }

            //返回结果    
            return finishFlag;
        }

        public void dfs(int node) {
            //标记这个node为已访问过的点
            visited[node] = 1;
            //遍历子节点
            for (int value : edges.get(node)) {
                //如果没有访问过，进行dfs递归
                if (visited[value] == 0) {
                    dfs(value);
                    //若结束发现finishFlag已经为false，返回上一层
                    if (!finishFlag) {
                        return;
                    }
                    //若节点已经访问过，设置finishFlag，并返回上一层
                } else if (visited[value] == 1) {
                    finishFlag = false;
                    return;
                }
            }
            //若执行到这，则此节点为不会重复的节点
            visited[node] = 2;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
