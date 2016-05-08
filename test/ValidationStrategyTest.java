import com.gabriel.strategy.IsAllLowerCase;
import com.gabriel.strategy.ValidationStrategy;
import com.gabriel.strategy.Validator;
import org.junit.Assert;
import org.junit.Test;

/**
 * Lambda expressions encapsulate a  piece of code (aka strategy)
 * which was the aim when this pattern was designed.
 */
public class ValidationStrategyTest {
    @Test
    public void testLowerCaseStrategy() {
        ValidationStrategy strategy = new IsAllLowerCase();
        String toEval = "ALL IN UPPER CASE";
        String toEval2 = toEval.toLowerCase();

        Assert.assertFalse(strategy.execute(toEval));
        Assert.assertTrue(strategy.execute(toEval2));
    }

    @Test
    public void testLowerCaseStrategyWithLambdas(){

        //Functional Interface
        ValidationStrategy strategy = s -> s.matches("[a-z ]+") ;
        String toEval = "ALL IN UPPER CASE";
        String toEval2 = toEval.toLowerCase();

        Assert.assertFalse(strategy.execute(toEval));
        Assert.assertTrue(strategy.execute(toEval2));
    }

    @Test
    public void testStrategyPassedByLambda(){

        //Functional Interface
        Validator validator = new Validator(s -> s.matches("[A-Z ]+"));
        String toEval = "ALL IN UPPER CASE";
        String toEval2 = toEval.toLowerCase();

        Assert.assertTrue(validator.isUpperCase(toEval));
        Assert.assertFalse(validator.isUpperCase(toEval2));
    }
}
