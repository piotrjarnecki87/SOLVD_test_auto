package course.hm.project.it.company;

public enum Technologies {
    JAVA("Java"),
    PYTHON("Python");

    private String description;

    Technologies(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
