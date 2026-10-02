package live.switchly.api.service;
import live.switchly.api.exception.NotFoundException;
import live.switchly.api.model.Project;
import live.switchly.api.repository.ProjectRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
@Service
public class ProjectService {
    private final ProjectRepository repository;
    private final OrganizationService organizationService;
    public ProjectService(ProjectRepository repository, OrganizationService organizationService) { this.repository = repository; this.organizationService = organizationService; }
    public Project create(UUID organizationId, String name) { organizationService.getById(organizationId); return repository.save(new Project(UUID.randomUUID(), organizationId, name)); }
    public List<Project> getAllForOrganization(UUID id) { organizationService.getById(id); return repository.findByOrganizationId(id); }
    public Project getById(UUID id) { return repository.findById(id).orElseThrow(() -> new NotFoundException("Project " + id + " was not found")); }
}
