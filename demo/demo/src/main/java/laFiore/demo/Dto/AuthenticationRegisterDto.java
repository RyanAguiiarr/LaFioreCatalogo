package laFiore.demo.Dto;

import laFiore.demo.RoleUser;

public record AuthenticationRegisterDto(
        String login, String password, RoleUser role
) {
}
