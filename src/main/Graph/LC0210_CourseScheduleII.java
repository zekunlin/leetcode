package Graph;
import java.util.*;

class CourseScheduleII {
    int curIdx;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses <= 0) return new int[]{};
        
        curIdx = numCourses - 1;
        int[] courseOrder = new int[numCourses];
        
        course[] courses = buildCourses(numCourses, prerequisites);
        for(int idx = 0; idx < numCourses; idx++){
            if(!completeCourse(courses, idx, courseOrder)) return new int[]{};
        }
        return courseOrder;
    }

    private boolean completeCourse(course[] courses, int idx, int[] courseOrder){
        course curCourse = courses[idx];
        if(curCourse.status == 1) return false;

        if(curCourse.status == 2) return true;

        curCourse.status = 1;
        
        List<Integer> nextCourses = curCourse.nexts;

        if(nextCourses.size() > 0){
            for(int next : nextCourses){
                if(!completeCourse(courses, next, courseOrder)) return false;
            }
        }

        curCourse.status = 2;
        courseOrder[curIdx--] = curCourse.val;
        return true; 
    }

    private course[] buildCourses(int numCourses, int[][] prerequisites){
        course[] courses = new course[numCourses];
        for(int i = 0; i < numCourses; i++){
            courses[i] = new course(i);
        }

        for(int[] req : prerequisites){
            courses[req[1]].nexts.add(req[0]);
        }
        return courses;
    }

    class course{
        int val;
        List<Integer> nexts;
        int status; //0,1,2 -> initial, visiting, visited
        public course(int val){
            this.val = val;
            nexts = new ArrayList<>();
            status = 0;
        }
    }
}
