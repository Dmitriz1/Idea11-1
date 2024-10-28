public class Meeting extends Task {
    protected String topic;
    protected String projectName;
    protected String startTime;

    public Meeting(int id, String topic, String projectName, String startTime) {
        super(id);
        this.topic = topic;
        this.projectName = projectName;
        this.startTime = startTime;
    }

    public String getTopic() {
        return topic;
    }
    public String getProjectName() {
        return projectName;
    }
    public String getStartTime() {
        return startTime;
    }

    @Override
    public boolean matches(String query) {
        if (topic.contains(query)) {
            return true;
        }
        if (projectName.contains(query)) {
            return true;
        }
        return false;
    }
}