package scripts;

import org.testng.annotations.Test;

public class _15_GroupsTest {
    @Test(priority = 1,groups = {"Functional", "Login"})
    public void test6(){
        System.out.println("This is test6");
    }
}
