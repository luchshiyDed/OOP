import java.util.Arrays;

public class studentBook {
    public class gradeExeption extends Exception {
        public gradeExeption(String a) {
            super(a);
        }
    }

    private class lesson {
        lesson(String name, int f, int l) {
            nam = name;
            fsem = f;
            lsem = l;
        }

        int[] grades;
        String nam;
        int fsem;
        int lsem;
    }

    void extArr(int ln) {
        classes = Arrays.copyOf(classes, ln);
    }

    private String name;
    private lesson[] classes=new lesson[1];
    private int n = 0;
    private int cap = 1;

    private int semesterNum = 1;
    private int semestrStip=0;

    private int medGrade = 0;
    private int medGradecnt = 0;

    private int diplomflag = 0;
    private int diplomGrade = 0;
    private int diplomGradecnt = 0;

    private int qualGrade = 0;

    /**
     * @param val -name of a student
     */
    public studentBook(String val) {
        String name = val;
    }

    public void setqGrade(int grade) throws Exception {
        if (grade > 5 || grade < 2) {
            Exception e = new gradeExeption("qualification grade-Has invalid grade. Grade must be between 2 and 5");
            throw e;
        }
        qualGrade = grade;
    }

    /**
     * @param nam      - name of a class
     * @param semester - number of a semester
     * @param newgrade - new grade
     * @throws Exception
     */
    public void setGrade(String nam, int semester, int newgrade) throws Exception {
        int j;
        for (j = 0; j < n; j++) {
            if (nam == classes[j].nam) break;
        }
        if (j == n) {
            Exception e = new gradeExeption(nam + "- No such class found");
            throw e;
        }
        if (semester > classes[j].lsem || semester < classes[j].fsem) {
            Exception e = new gradeExeption(classes[j].nam + "- There is no such class in this semester or invalid semester number");
            throw e;
        }
        if (newgrade > 5 || newgrade < 2) {
            Exception e = new gradeExeption(classes[j].nam + "-Has invalid grade. Grade must be between 2 and 5");
            throw e;
        }
        int sem=(semester-1)%3;
        if (classes[j].grades[sem] != 0) {
            if (classes[j].grades[sem] < 4 && newgrade > 3) {
                diplomflag--;
            }
            if (classes[j].grades[sem] > 3 && newgrade < 4) {
                diplomflag++;
            }
            medGrade = medGrade - classes[j].grades[sem] + newgrade;
            if (semester == classes[j].fsem) {
                diplomGrade = diplomGrade - classes[j].grades[sem] + newgrade;
            }
        } else {
            if (newgrade< 4){
                diplomflag++;
            }
            medGrade+=newgrade;
            medGradecnt++;
            if (semester == classes[j].lsem) {
                diplomGrade+=newgrade;
                diplomGradecnt++;
            }
        }
        if (semester == semesterNum+1) {
            semesterNum = semester;
        }
        classes[j].grades[sem] = newgrade;

    }

    /**
     * @param val            -name of a class
     * @param first_semester - number of first semester
     * @param last_semester  - number of last semester
     * @throws Exception
     */
    public void addClass(String val, int first_semester, int last_semester) throws Exception {
        if (first_semester < 1 || first_semester > last_semester || last_semester < 1 || last_semester>10) {
            Exception e = new gradeExeption(val + " Has invalid number of semesters");
            throw e;
        }
        if (n >= cap)
            extArr(cap = n * 2 + 1);
        classes[n]=new lesson (val, first_semester, last_semester);
        classes[n].grades = new int[last_semester - first_semester + 1];
        n++;
    }

    public double mediumGrades() {
        if(medGradecnt==0)return 0;
        return ((double) medGrade / (double) medGradecnt);
    }

    public boolean diplom() {
        if(diplomGradecnt==0)return false;
        return ((double) diplomGrade / (double) diplomGradecnt) >= 4.75 && (diplomflag == 0) && qualGrade == 5;
    }

    public boolean stipendia() {
        for (int j = 0; j < n; j++) {
            boolean x = classes[j].lsem >= semesterNum && classes[j].fsem <= semesterNum;
            if (classes[j].grades[(semesterNum-1)%3] != 5 && x)
                return false;
        }
        return true;

    }


}
