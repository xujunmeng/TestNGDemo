package dependsOnMethods;

import org.testng.annotations.Test;

/**
 * @author james
 * @date 2018/8/21
 */
public class TestDependenceDemo3 {

    @Test(groups = {"tomcat"})
    public void restartTomcatService(){
        System.out.println("Restart the tomcat server when it is down!");
    }

    @Test(groups = {"tomcat"})
    public void tomcatServiceIsDown(){
        System.out.println("tomcat service is down!");
    }

    @Test(groups = {"app"})
    public void startAppServer(){
        System.out.println("Start App service");
    }

    @Test(groups = {"app"})
    public void shutDownApp(){
        System.out.println("Shutdown App service");
    }


}
