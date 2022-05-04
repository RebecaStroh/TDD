package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

public class NotaFiscarTest {
    @Test
    @Order(1)
    void test () {
        try {
            Fatura
            assertEquals(0,0);
        } catch (Exception e) {
            System.out.println("");
        }
    }
}
