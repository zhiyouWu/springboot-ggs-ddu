package top.flygrk.ishare.spi.api.impl;

import top.flygrk.ishare.spi.api.HelloSpi;

/**
 * @Package top.flygrk.ishare.spi.api.impl
 * @Author wuzy@watone.com.cn
 * @Date 2019/9/27 09:13
 * @Version V1.0
 * @Description:
 */
public class ImageHello implements HelloSpi {
    @Override
    public void sayHello() {
        System.out.println("Image Hello");
    }
}
