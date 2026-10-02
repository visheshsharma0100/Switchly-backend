package live.switchly.api.repository;
import live.switchly.api.model.Flag;
import java.util.*;
public interface FlagRepository {
    Flag save(Flag flag);
    Optional<Flag> findById(UUID id);
    List<Flag> findByProjectId(UUID projectId);
    boolean existsByProjectIdAndKey(UUID projectId, String key);
    void delete(Flag flag);
}
