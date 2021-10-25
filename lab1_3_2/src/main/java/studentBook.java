public class studentBook {
    public class gradeExeption extends Exception{
        public gradeExeption(String a){
            super(a);
        }
    }
    private class lesson{
        void set(String name,int f,int l)
        {
            nam=name;
            fsem=f;
            lsem=l;
        }
        String nam;
        int fsem;
        int lsem;
    }
    private String name;
    private int[][] grades;
    private lesson[] classes;
    private int n;
    private int i=0;

    private int semesterNum=0;

    private int medGrade=0;
    private int medGradecnt=0;

    private int diplomflag=0;
    private int diplomGrade=0;
    private int diplomGradecnt=0;

    private int qualGrade=0;

    /**
     *
     * @param val -name of a student
     * @param num -number of classes
     */
    public studentBook(String val,int num){
        n=num;
        String name = val;
        grades=new int[n][4*n];
        classes=new lesson[n];
    }
    public void setqGrade(int grade) throws Exception {
        if(grade>5||grade<2) {
            Exception e=new gradeExeption("qualification grade-Has invalid grade. Grade must be between 2 and 5");
            throw e;
        }
        qualGrade=grade;
    }
    /**
     *
     * @param nam - name of a class
     * @param semester - number of a semester
     * @param newgrade - new grade
     * @throws Exception
     */
    public void changeGrade(String nam,int semester,int newgrade) throws Exception {
        int j;
        for(j=0;j<n;j++){if(nam!=classes[j].nam) break;}
        if(j==n){
            Exception e=new gradeExeption(classes[j].nam + "- No such class found");
            throw e;
        }
        if(semester>classes[j].fsem || semester<classes[j].lsem){
            Exception e=new gradeExeption(classes[j].nam + "- There is no such class in this semester");
            throw e;
        }
        if(newgrade>5 || newgrade<2){
            Exception e=new gradeExeption(classes[j].nam + "-Has invalid grade. Grade must be between 2 and 5");
            throw e;
        }
        else{
            if(grades[j][semester]<4&&newgrade>3){
                diplomflag--;
            }
            grades[j][semester]=newgrade;
        }
    }
    /**
     *
     * @param val -name of a class
     * @param first_semester - number of first semester
     * @param last_semester - number of last semester
     * @throws Exception
     */
    public void addClass(String val,int first_semester,int last_semester) throws Exception {
        if (first_semester<1 || first_semester>last_semester || last_semester<1){
            Exception e = new gradeExeption(classes[i].nam + " Has invalid number of semesters");
            throw e;
        }
        classes[i++].set(val,first_semester,last_semester);
    }

    /**
     *
     * @param semesterGrades - semester grades
     * @throws Exception
     */
    public void addGrades(int[] semesterGrades) throws Exception {
        if (semesterGrades.length!=n){
            Exception e=new gradeExeption("There must be as much grades as classes");
            throw e;
        }
       for(int j=0;j<n;j++){
           if(semesterGrades[j]>5 || semesterGrades[j]<2){
                Exception e=new gradeExeption(classes[j].nam + "-Has invalid grade. Grade must be between 2 and 5");
                throw e;
           }
           grades[j][semesterNum]=semesterGrades[j];
           boolean x =classes[j].lsem<=semesterNum&&classes[j].fsem>=semesterNum;
           medGrade+=x?semesterGrades[j]:0;
           medGradecnt+=x?1:0;
           if (semesterGrades[j]<4&&x) {
               diplomflag++;
           }
           x=classes[j].fsem==semesterNum;

           diplomGrade+=x?semesterGrades[j]:0;
           diplomGradecnt+=x?1:0;
       }
        semesterNum++;
    }
    public double mediumGrades(){
        return ((double)medGrade/(double)medGradecnt);
    }
    public boolean diplom(){
        return ((double)diplomGrade/(double)diplomGradecnt)>=4.75&&(diplomflag==0)&&qualGrade==5;
    }
    public boolean stipendia(){
        for (int j=0;j<n;j++){
        boolean x =classes[j].lsem<=semesterNum&&classes[j].fsem>=semesterNum;
        if (grades[j][semesterNum]!=5&&x)
            return false;
        }
        return true;

    }


}
