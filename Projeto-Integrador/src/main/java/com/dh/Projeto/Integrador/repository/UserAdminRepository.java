package com.dh.Projeto.Integrador.repository;

import com.dh.Projeto.Integrador.model.UserAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAdminRepository extends JpaRepository<UserAdmin, Integer> {

    UserAdmin findByEmail(String email);
}
