package dependsOnMethods;

import org.testng.annotations.Test;

/**
 *
 * 在Testng中依赖分两种，硬依赖和软依赖
 * 硬依赖就是所有的依赖方法必须成功执行，
 * 才会执行接下来的方法，如果其中有一个依赖的方法失败了，那
 * 么接下来的方法是不会被执行，会默认标记跳过（skip）。
 *
 * 上面重启tomcat服务的方法运行的前提是tomcatServiceIsDown()，
 * 只有tomcat服务确实挂了，才会执行重启的方法，这个就是硬依赖
 *
 *
 * @author james
 * @date 2018/8/21
 */
public class TestDependenceDemo {

    @Test(dependsOnMethods = "tomcatServiceIsDown")
    public void restartTomcatService(){
        System.out.println("Restart the tomcat server when it is down!");
    }

    @Test
    public void tomcatServiceIsDown(){
        System.out.println("tomcat service is down!");
    }

}
