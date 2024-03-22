package kr.basic.security.auth;

import kr.basic.security.entity.Users;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

// 시큐리티가 /login 주소가 오면 낚아서 로그인 진행
// login 완료 -> security session 을 만든다 (Security ContextHolder)
// type --> authentication type object
// authentication 객체 --> user 정보를 넣어야함 => userDetails

@Data
public class PrincipalDetails implements UserDetails {

    private Users user;

    public PrincipalDetails(Users user){
        this.user = user;
    }


    // user 권한 넘겨준다
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return user.getRole().toString();
            }
        });
        return collection;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    // 계정이 만료되지않았는가?
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
  // 계정이 잠가지지 않았나?
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
  // user 비번이 기간이 지났나?
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 계정이 활성화 되어있는가?
    @Override
    public boolean isEnabled() {
        // 계정이 비활성화 될때 : 1년동안 방문하지 않는 사이트 -> 휴면계정
        return true;
    }
}
