package live.switchly.api.service;
import live.switchly.api.exception.NotFoundException;
import live.switchly.api.model.Organization;
import live.switchly.api.repository.OrganizationRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
@Service
public class OrganizationService {
    private final OrganizationRepository repository;
    public OrganizationService(OrganizationRepository repository) { this.repository = repository; }
    public Organization create(String name) { return repository.save(new Organization(UUID.randomUUID(), name)); }
    public List<Organization> getAll() { return repository.findAll(); }
    public Organization getById(UUID id) { return repository.findById(id).orElseThrow(() -> new NotFoundException("Organization " + id + " was not found")); }
}
