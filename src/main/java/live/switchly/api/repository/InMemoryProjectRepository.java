package live.switchly.api.repository;
import live.switchly.api.model.Project;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
@Repository
public class InMemoryProjectRepository implements ProjectRepository {
    private final Map<UUID, Project> store = new ConcurrentHashMap<>();
    public Project save(Project project) { store.put(project.getId(), project); return project; }
    public Optional<Project> findById(UUID id) { return Optional.ofNullable(store.get(id)); }
    public List<Project> findByOrganizationId(UUID id) { return store.values().stream().filter(p -> p.getOrganizationId().equals(id)).collect(Collectors.toList()); }
}
