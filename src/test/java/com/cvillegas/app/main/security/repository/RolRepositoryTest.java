package com.cvillegas.app.main.security.repository;

import com.cvillegas.app.main.security.entity.Role;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
class RolRepositoryTest {
    @Autowired private RolRepository repository;

    @Test
    public void findAll() {
        List<Role> rols = this.repository.findAll();
        Assertions.assertTrue( !rols.isEmpty() );
        Assertions.assertTrue( rols.size() == 2 );
    }
}