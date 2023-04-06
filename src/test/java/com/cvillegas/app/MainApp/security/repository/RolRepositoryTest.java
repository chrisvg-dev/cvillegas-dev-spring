package com.cvillegas.app.MainApp.security.repository;

import com.cvillegas.app.MainApp.security.entity.Rol;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class RolRepositoryTest {
    @Autowired private RolRepository repository;

    @Test
    public void findAll() {
        List<Rol> rols = this.repository.findAll();

        Assertions.assertTrue( !rols.isEmpty() );
    }

}