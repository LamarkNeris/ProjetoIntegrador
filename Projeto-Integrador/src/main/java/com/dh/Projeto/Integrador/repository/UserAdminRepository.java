package com.dh.Projeto.Integrador.repository;

import com.dh.Projeto.Integrador.model.UserAdmin;
import com.dh.Projeto.Integrador.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAdminRepository extends JpaRepository<UserAdmin, Integer> {

    UserAdmin findByEmail(String email);


}
