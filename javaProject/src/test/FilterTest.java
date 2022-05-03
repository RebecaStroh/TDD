package test;

import static org.junit.jupiter.api.Assertions.*;

import main.Cliente;
import main.Fatura;
import main.Filter;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.List;

public class FilterTest {
    public static Filter filter;
    public static Cliente clienteA;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        System.out.print("Configurando os testes ... ");

        filter = new Filter();
        clienteA = new Cliente("Fulano de tal", "11/08/1997", "São Paulo");

        System.out.println("OK");
    }

    @Test
    @Order(1)
    void testEmptyList() {
        try {
            List<Fatura> faturas = new ArrayList<Fatura>();
            List<Fatura> filteredFaturas = filter.filterFaturas(faturas);
            assertEquals(true, filteredFaturas.isEmpty());
        } catch (Exception e) {
            System.out.println("Uma lista de faturas vazia deve retornar uma lista vazia");
            e.printStackTrace();
        }
    }

    @Test
    @Order(2)
    void testOneItemListLessThan2000() {
        try {
            List<Fatura> faturas = new ArrayList<Fatura>();
            Fatura a = new Fatura(1234, 1000, "10/05/2020", clienteA);
            faturas.add(a);
            List<Fatura> filteredFaturas = filter.filterFaturas(faturas);
            assertEquals(true, filteredFaturas.isEmpty());
        } catch (Exception e) {
            System.out.println("Uma lista com um item dentro do filtro com o valor da fatura for menor que 2000");
            e.printStackTrace();
        }
    }
}
