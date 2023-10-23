package com.cvillegas.app.main.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UserRepositoryTest {

    @Test
    public void getAllUsersTest() {
        Assertions.assertTrue(1 == 1);
        log.info("Printed");
    }
}
