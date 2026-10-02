package live.switchly.api.controller;
import jakarta.validation.Valid;
import live.switchly.api.dto.CreateOrganizationRequest;
import live.switchly.api.model.Organization;
import live.switchly.api.service.OrganizationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/api/v1/orgs")
public class OrganizationController {
    private final OrganizationService service;
    public OrganizationController(OrganizationService service) { this.service = service; }
    @PostMapping @ResponseStatus(HttpStatus.CREATED) public Organization create(@Valid @RequestBody CreateOrganizationRequest request) { return service.create(request.name()); }
    @GetMapping public List<Organization> getAll() { return service.getAll(); }
    @GetMapping("/{orgId}") public Organization getById(@PathVariable UUID orgId) { return service.getById(orgId); }
}
