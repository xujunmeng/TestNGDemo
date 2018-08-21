package 测试一;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * @author james
 * @date 2018/8/21
 */
public class TestHelloWorld {

    @BeforeClass
    public void setUp(){
        System.out.println("启动测试的前提条件准备，一般放这个方法中");
    }

    @Test
    @Parameters({"people"})
    public void test(String people) {
        System.out.println(people);
    }

    @AfterClass
    public void tearDown(){
        System.out.println("测试运行结束后的步骤，一般是恢复环境到测试开始之前的状态");
    }

    @Test
    public void test1() {
        System.out.println("Hello");
    }

    @Test
    @Parameters({"Browser", "Server"})
    public void test1(String browser, String server){
        System.out.println("Hello");
        System.out.println("这次启动浏览器是： "+browser+" 测试服务器地址是： "+server);
    }

    @Test(timeOut = 3000)
    public void loginTest(){
        try{
            Thread.sleep(2999);
        }catch (InterruptedException e){
            System.out.println(e.toString());
        }
    }

    @Test(enabled=false)
    public void test2(){
        System.out.println("test2");
    }

    @Test(priority = 2)
    public void test3(){
        System.out.println("test3");
    }

    @Test(priority = 4)
    public void test4(){
        System.out.println("test4");
    }

    @Test(priority = 1)
    public void test5(){
        System.out.println("test5");
    }

    //设置了执行次数数5次，5次执行总共耗时不能超过5100毫秒，否则抛出中断异常
    @Test(invocationCount = 100, invocationTimeOut = 5100, threadPoolSize = 50)
    public void test6() throws InterruptedException{
        System.out.println(Thread.currentThread().getName() + " : login test");
    }

    @Test(dependsOnMethods={"test4"})
    public void test7(){
        System.out.println("test7 依赖 test4");
    }

    @Test
    public void AssertTest1(){
        Assert.assertEquals(12,12);
        Assert.assertEquals("ABC", "ABC", "not equals");
    }

    @Test
    public void AssertTest2(){

        String[] st1 = {"Anthony", "Tom", "Jhon"};
        String[] st2 = {"Jhon", "Anthony", "Tom"};
        Assert.assertEqualsNoOrder(st1, st2, "两个字符串数组不相同");
    }

    /**
     * SoftAssert的特点
     * 1）  如果一个断言失败，会继续执行这个断言下的其他语句或者断言。
     * 2）  也就是一个用例有多个断言，失败了其中一个，不影响其他断言的运行
     * 3）  不要忘记调用assertAll()在该用例的最后一个断言后面。
     */
    @Test
    public void testSoftAssert(){
        System.out.println("Test start");
        SoftAssert assertion = new SoftAssert();
        assertion.assertEquals(13, 13,"两者不相等");
        System.out.println("Test complete");
        System.out.println(3+8);
        assertion.assertAll();
    }







}
