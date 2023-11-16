import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)

@Suite.SuiteClasses({
        TestCar.class,
        TestSaab.class,
        TestVolvo.class,
        TestScania.class,
        TestCarTransport.class,
        TestMechanic.class
})
public class TestSuite {
}
