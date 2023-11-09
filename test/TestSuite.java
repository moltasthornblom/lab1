import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)

@Suite.SuiteClasses({
        TestCar.class,
        TestSaab.class,
        TestVolvo.class
})
public class TestSuite {
}
