public class StaffMember extends Person{
    private String staffNumber;
    private String department;

    public StaffMember(String name, String id, String staffNumber, String department) {
        super(name, id);
        this.staffNumber = staffNumber;
        this.department = department;
    }

    public String getStaffNumber () {
        return staffNumber;
    }

    public String getDepartment () {
        return department;
    }

    @Override 
    public String toString () {
        return String.format("%s %s %s %s", getName(), getId(), getStaffNumber(), getDepartment());
    }
}
