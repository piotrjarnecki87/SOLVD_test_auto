package course.hm.project.it.company;

import course.hm.project.it.company.exceptions.TestExecutionException;
import course.hm.project.it.company.interfaces.Tester;

import java.util.Objects;

public class AutomotiveSoftwareTester extends Employee implements Tester {
    private ProjectA projectA;



    public AutomotiveSoftwareTester(String name, int employeeId, ProjectA projectA) {
        super(name, employeeId, projectA);
        this.projectA = projectA;
    }
@Override
    public void runTests() {
        System.out.println(getName() + " - Automotive Software Tester is running tests.");
    }


    @Override
    public void workOnProject() {
        try {
            if (getProjectA() != null) {
                System.out.println(getName() + " is running tests on the  " + getProjectA());

                if (testExecutionFails()) {
                    throw new TestExecutionException("Test execution failed!!.");
                }
            } else {
                throw new IllegalArgumentException(getName() + " is running tests on an undefined project.");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("UndefinedProjectException caught: " + e.getMessage());

        } catch (TestExecutionException e) {
            System.out.println("TestExecutionException caught: " + e.getMessage());

        }
    }

    private boolean testExecutionFails() {

        return true;
    }


    @Override
    public ProjectA getProjectA() {
        return projectA;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AutomotiveSoftwareTester that = (AutomotiveSoftwareTester) o;
        return Objects.equals(projectA, that.projectA);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), projectA);
    }

    @Override
    public String toString() {
        return "AutomotiveSoftwareTester{" +
                "name='" + getName() + '\'' +
                ", employeeId=" + getEmployeeId() +
                ", projectA='" + projectA + '\'' +
                '}';
    }
}
