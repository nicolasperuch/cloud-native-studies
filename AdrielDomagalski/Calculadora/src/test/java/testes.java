import com.github.adrielsoares.java.spring4.calculadora.Configuracao.Operacoes.Calculo;
import com.github.adrielsoares.java.spring4.calculadora.Configuracao.Operacoes.Operacao;
import com.github.adrielsoares.java.spring4.calculadora.Configuracao.Operacoes.Soma;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ilegra0267 on 24/05/2017.
 */
public class testes {
   private Calculo calculador = new Calculo();
    @Test
    public void TesteSoma(){
        String soma = String.valueOf(calculador.calcula(5, 5, "+"));
        Assert.assertEquals("10.0", soma);
    }

    @Test
    public void TesteSubtracao(){
        String sub = String.valueOf(calculador.calcula(5, 3, "-"));
        Assert.assertEquals("2.0", sub);
    }

    @Test
    public void TesteSMultiplicacao(){
        String mult = String.valueOf(calculador.calcula(5, 5, "*"));
        Assert.assertEquals("25.0", mult);
    }

    @Test
    public void TesteDivisao(){
        String div = String.valueOf(calculador.calcula(6, 2, "/"));
        Assert.assertEquals("3.0", div);
    }

    @Test
    public void TestePotencia(){
        String pot = String.valueOf(calculador.calcula(7, 2, "^"));
        Assert.assertEquals("49.0", pot);
    }

}
