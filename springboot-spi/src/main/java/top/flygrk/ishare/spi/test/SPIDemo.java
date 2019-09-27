package top.flygrk.ishare.spi.test;

import top.flygrk.ishare.spi.api.HelloSpi;

import java.util.ServiceLoader;

/**
 * @Package top.flygrk.ishare.spi.test
 * @Author wuzy@watone.com.cn
 * @Date 2019/9/27 09:17
 * @Version V1.0
 * @Description:
 */
public class SPIDemo {
    public static void main(String[] args) {
        ServiceLoader<HelloSpi> serviceLoader = ServiceLoader.load(HelloSpi.class);
        for (HelloSpi helloSpi : serviceLoader) {
            helloSpi.sayHello();
        }
    }
}
