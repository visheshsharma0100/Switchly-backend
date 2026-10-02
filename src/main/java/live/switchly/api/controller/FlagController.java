package live.switchly.api.controller;
import jakarta.validation.Valid;
import live.switchly.api.dto.CreateFlagRequest;
import live.switchly.api.dto.UpdateFlagStateRequest;
import live.switchly.api.model.Flag;
import live.switchly.api.service.FlagService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/api/v1")
public class FlagController {
    private final FlagService service;
    public FlagController(FlagService service) { this.service = service; }
    @PostMapping("/projects/{projectId}/flags") @ResponseStatus(HttpStatus.CREATED) public Flag create(@PathVariable UUID projectId, @Valid @RequestBody CreateFlagRequest request) { return service.create(projectId, request.key(), request.name(), request.description()); }
    @GetMapping("/projects/{projectId}/flags") public List<Flag> getAllForProject(@PathVariable UUID projectId) { return service.getAllForProject(projectId); }
    @GetMapping("/flags/{flagId}") public Flag getById(@PathVariable UUID flagId) { return service.getById(flagId); }
    @PutMapping("/flags/{flagId}/state") public Flag setState(@PathVariable UUID flagId, @Valid @RequestBody UpdateFlagStateRequest request) { return service.setEnabled(flagId, request.enabled()); }
    @DeleteMapping("/flags/{flagId}") public ResponseEntity<Void> delete(@PathVariable UUID flagId) { service.delete(flagId); return ResponseEntity.noContent().build(); }
}
