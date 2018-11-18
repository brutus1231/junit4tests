package pl.sda;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RunWith(value = Parameterized.class)
public class FibonacciChainTest {

    private FibonacciChain fibonacciChain;
    private Integer argument;
    private Integer expectedResult;

    public FibonacciChainTest(Integer argument, Integer expectedResult){
        this.argument = argument;
        this.expectedResult = expectedResult;
    }

    @BeforeClass
    public static void beforeClass(){
        System.out.println("Before class");
    }

    @Before
    public void before() {
        System.out.println("Before");
        fibonacciChain = new FibonacciChain();
    }

    @Test
    public void testFirstElementReturn1() {
        Integer result = fibonacciChain.calculate(1);
        Integer expectedResult = 1;
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void testFifthElementReturn5() {
        Integer result = fibonacciChain.calculate(5);
        Integer expectedResult = 5;
        Assert.assertEquals(expectedResult, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentWhenMinusParam(){
        Integer result = fibonacciChain.calculate(-1 * argument);
    }

    @Test
    public void shouldReturnExpectedResults() {
        Integer result = fibonacciChain.calculate(argument);
        Assert.assertEquals(result, expectedResult);
    }

    @Parameterized.Parameters
    public static Collection<Integer[]> dataProducer() {
        List<Integer[]> params = new ArrayList<>();
        addIntTableToParams(params, 1, 1);
        addIntTableToParams(params, 2, 1);
        addIntTableToParams(params, 3, 2);
        addIntTableToParams(params, 4, 3);
        addIntTableToParams(params, 5, 5);
        addIntTableToParams(params, 6, 8);
        return params;
    }

    private static void addIntTableToParams(List<Integer[]> params,
                                                 int param1, int param2) {
        params.add(new Integer[]{param1, param2});
    }
}
