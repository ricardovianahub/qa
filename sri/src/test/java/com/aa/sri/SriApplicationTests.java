package com.aa.sri;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
class SriApplicationTests {

    @Value("${csretrieve}")
    private String label1;

	@Test
	void readVariablesFromApplicationProperties() {
        System.out.println(label1);
	}

}
