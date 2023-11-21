package com.cvillegas.app.main.security.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
class RolRepositoryTest {

    @Test
    public void findAll() {
        //List<Role> rols = this.repository.findAll();
        //Assertions.assertTrue( !rols.isEmpty() );
        //Assertions.assertTrue( rols.size() == 2 );
    }
}