package com.ylw.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户实体绑定spring security
 *
 * @author : YangLinWei
 * @createTime: 2021/6/10 5:18 下午
 */
@Getter
@Setter
public class LoginAppUser extends SysUser implements SocialUserDetails {
    private static final long serialVersionUID = -3685249101751401211L;

    private Set<String> permissions;

    /***
     * 权限重写
     */
    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new HashSet<>();
        if (!CollectionUtils.isEmpty(super.getRoles())) {
            super.getRoles().parallelStream().forEach(role -> collection.add(new SimpleGrantedAuthority(role.getCode())));
        }
        return collection;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return getEnabled();
    }

    @Override
    public String getUserId() {
        return getOpenId();
    }
}
