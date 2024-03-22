package kr.basic.security.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleUser {
    USER("user"),ADMIN("admin"),MANAGER("manager");
    private final String role;
}
