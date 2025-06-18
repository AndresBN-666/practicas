import org.example.clases.CuentaBancaria;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CuentaTest {

    @Test
    public void depositarTest(){
        CuentaBancaria cuentaBancaria = new CuentaBancaria("Ana", 1000.0);
        cuentaBancaria.depositar(500.0);
        assertEquals(1500.0, cuentaBancaria.getSaldo());

        cuentaBancaria.retirar(200.0);
        assertEquals(1300.0, cuentaBancaria.getSaldo());

        cuentaBancaria.retirar(2000.0);
        //assertEquals("Saldo insuficiente", cuentaBancaria.getSaldo());

    }
}
