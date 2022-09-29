
package com.catalyst.funds.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.catalyst.funds.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    RoleEntity findByName(String name);
}