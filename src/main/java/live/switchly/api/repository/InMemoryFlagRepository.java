package live.switchly.api.repository;
import live.switchly.api.model.Flag;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
@Repository
public class InMemoryFlagRepository implements FlagRepository {
    private final Map<UUID, Flag> store = new ConcurrentHashMap<>();
    public Flag save(Flag flag) { store.put(flag.getId(), flag); return flag; }
    public Optional<Flag> findById(UUID id) { return Optional.ofNullable(store.get(id)); }
    public List<Flag> findByProjectId(UUID id) { return store.values().stream().filter(f -> f.getProjectId().equals(id)).collect(Collectors.toList()); }
    public boolean existsByProjectIdAndKey(UUID id, String key) { return store.values().stream().anyMatch(f -> f.getProjectId().equals(id) && f.getKey().equals(key)); }
    public void delete(Flag flag) { store.remove(flag.getId()); }
}
