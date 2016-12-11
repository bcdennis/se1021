package lecture04;

/**
 * Created by Brad on 12/5/2016.
 */
public class CEProgram extends Program {
    private static final String NAME = "CE Program";
    private static final String DEPARTMENT = "EECS";


    @Override
    public void setChair(FulltimeFaculty chair) {
        if(chair.getRank().equals(FulltimeFaculty.ASSOCIATE_PROFESSOR)
                || chair.getRank().equals(FulltimeFaculty.FULL_PROFESSOR)) {
            super.setChair(chair);
        }
    }

    /**
     * No argument constructor
     */
    public CEProgram() {
        super(NAME, DEPARTMENT);
    }


}
