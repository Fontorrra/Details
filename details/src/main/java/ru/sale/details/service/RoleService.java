package ru.sale.details.service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sale.details.models.Role;
import ru.sale.details.repository.RoleRepository;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role getUserRole() {
        return roleRepository.findByName("ROLE_USER").get();
    }
}