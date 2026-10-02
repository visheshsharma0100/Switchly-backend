package live.switchly.api.service;
import live.switchly.api.exception.ConflictException;
import live.switchly.api.exception.NotFoundException;
import live.switchly.api.model.Flag;
import live.switchly.api.repository.FlagRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
@Service
public class FlagService {
    private final FlagRepository repository;
    private final ProjectService projectService;
    public FlagService(FlagRepository repository, ProjectService projectService) { this.repository = repository; this.projectService = projectService; }
    public Flag create(UUID projectId, String key, String name, String description) {
        projectService.getById(projectId);
        if (repository.existsByProjectIdAndKey(projectId, key)) throw new ConflictException("Flag key '" + key + "' already exists in this project");
        return repository.save(new Flag(UUID.randomUUID(), projectId, key, name, description, false));
    }
    public List<Flag> getAllForProject(UUID id) { projectService.getById(id); return repository.findByProjectId(id); }
    public Flag getById(UUID id) { return repository.findById(id).orElseThrow(() -> new NotFoundException("Flag " + id + " was not found")); }
    public Flag setEnabled(UUID id, boolean enabled) { Flag flag = getById(id); flag.setEnabled(enabled); return repository.save(flag); }
    public void delete(UUID id) { repository.delete(getById(id)); }
}
