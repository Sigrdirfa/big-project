package com.witnesses.web.entity;

import com.witnesses.web.constant.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

import static jakarta.persistence.GenerationType.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "user",
        uniqueConstraints = {
                @UniqueConstraint(name = "email_unique", columnNames = {"email"})
        })
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = UUID)
    private String id;

    private String firstName;

    private String lastName;

    private String email;

    private String passWord;

    @Enumerated(EnumType.STRING)
    private Role role;

    private Boolean enabled;

    private Boolean isExpired;

    private Boolean isCredentialsExpired;

    private Boolean isLocked;

//    private List<Role> roles;

    @Column(name = "created_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @CreatedDate
    @Generated(GenerationTime.INSERT)
    private Timestamp createdDate;

    @Column(name = "modified_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @UpdateTimestamp
    private Timestamp modifiedDate;

    private String createdBy;

    private String modifiedBy;

    private Boolean isDeleted;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return passWord;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.isExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.isLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.isCredentialsExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
