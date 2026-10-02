package live.switchly.api.repository;
import live.switchly.api.model.Organization;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
@Repository
public class InMemoryOrganizationRepository implements OrganizationRepository {
    private final Map<UUID, Organization> store = new ConcurrentHashMap<>();
    public Organization save(Organization organization) { store.put(organization.getId(), organization); return organization; }
    public Optional<Organization> findById(UUID id) { return Optional.ofNullable(store.get(id)); }
    public List<Organization> findAll() { return new ArrayList<>(store.values()); }
}
