package dependsOnMethods;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * 软依赖就是不管依赖的方法是否成功执行，
 * 接下来的方法都可以运行。
 * 软依赖的实现是在@Test中添加属性alwaysRun=true来实现。
 *
 * @author james
 * @date 2018/8/21
 */
public class TestDependenceDemo2 {

    @Test(groups = {"tomcat"})
    public void restartTomcatService(){
        System.out.println("Restart the tomcat server when it is down!");
    }

    @Test(groups = {"tomcat"})
    public void tomcatServiceIsDown(){
        System.out.println("tomcat service is down!");
        Assert.assertTrue(11==11);
    }

    @Test(dependsOnGroups = {"tomcat"}, alwaysRun = true)
    public void startAppServer(){
        System.out.println("Start App service");
    }


}
