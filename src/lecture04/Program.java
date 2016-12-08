package lecture04;

/**
 * Created by Brad on 12/5/2016.
 */
public abstract class Program {
    private FulltimeFaculty chair;
    private String name;
    private String department;

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public Faculty getChair() {
        return chair;
    }

    public void setChair(FulltimeFaculty chair) {
        this.chair = chair;
    }

    /**
     * REquired construct for Program.
     * @param name
     * @param department
     */
    public Program(String name, String department) {
        this.name = name;
        this.department = department;
    }


    /**
     * Displays the program information in a readable way.
     * @return
     */
    public String displayInformation() {
        String output = getName() + " in " + getDepartment() + " Chair: ";
        if (getChair() != null) {
            output += chair.getGreeting();
        } else {
            output += " None";
        }
        return output;
    }
}
