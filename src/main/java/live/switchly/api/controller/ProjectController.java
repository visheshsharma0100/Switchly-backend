package live.switchly.api.controller;
import jakarta.validation.Valid;
import live.switchly.api.dto.CreateProjectRequest;
import live.switchly.api.model.Project;
import live.switchly.api.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/api/v1")
public class ProjectController {
    private final ProjectService service;
    public ProjectController(ProjectService service) { this.service = service; }
    @PostMapping("/orgs/{orgId}/projects") @ResponseStatus(HttpStatus.CREATED) public Project create(@PathVariable UUID orgId, @Valid @RequestBody CreateProjectRequest request) { return service.create(orgId, request.name()); }
    @GetMapping("/orgs/{orgId}/projects") public List<Project> getAllForOrganization(@PathVariable UUID orgId) { return service.getAllForOrganization(orgId); }
    @GetMapping("/projects/{projectId}") public Project getById(@PathVariable UUID projectId) { return service.getById(projectId); }
}
