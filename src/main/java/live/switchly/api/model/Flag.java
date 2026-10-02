package live.switchly.api.model;
import java.util.UUID;
public class Flag {
    private final UUID id;
    private final UUID projectId;
    private final String key;
    private final String name;
    private final String description;
    private volatile boolean enabled;
    public Flag(UUID id, UUID projectId, String key, String name, String description, boolean enabled) {
        this.id = id; this.projectId = projectId; this.key = key; this.name = name; this.description = description; this.enabled = enabled;
    }
    public UUID getId() { return id; }
    public UUID getProjectId() { return projectId; }
    public String getKey() { return key; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public boolean isEnabled() { return enabled; }
    public void setEnabled(boolean enabled) { this.enabled = enabled; }
}
