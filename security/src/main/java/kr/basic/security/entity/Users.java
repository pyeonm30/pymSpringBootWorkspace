package kr.basic.security.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    @Enumerated(EnumType.STRING)
    private RoleUser role;
    @CreationTimestamp
    private Timestamp createDate;

    @Builder
    public Users(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = RoleUser.USER;
    }
}
