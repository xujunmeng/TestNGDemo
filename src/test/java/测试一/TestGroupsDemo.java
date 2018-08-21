package 测试一;

import org.testng.annotations.Test;

/**
 * @author james
 * @date 2018/8/21
 */
public class TestGroupsDemo {

    @Test(groups = {"API Test", "Fucntion Test"})
    public void test01(){
        System.out.println("API Testing and Function testing");
    }

    @Test(groups = {"API Test"})
    public void test02(){
        System.out.println("API Testing");
    }

    @Test(groups = {"Function Test"})
    public void test03(){
        System.out.println("Function testing");
    }

    @Test
    public void test04(){
        System.out.println("not in API and Function testing");
    }


}
