package top.flygrk.ishare.demo;

import top.flygrk.ishare.spi.service.SPIService;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @Package top.flygrk.ishare.demo
 * @Version V1.0
 * @Description: 测试 SPIService
 */
public class TestSPIService {

    public static void main(String[] args) {
        // ServiceLoader实现了Iterable接口，可以遍历出所有的服务实现者
        ServiceLoader<SPIService> serviceLoaders = ServiceLoader.load(SPIService.class);

        /*
         * 方法1： 迭代器
         */
        Iterator<SPIService> spiServiceIterator = serviceLoaders.iterator();
        while (spiServiceIterator != null && spiServiceIterator.hasNext()) {
            SPIService spiService = spiServiceIterator.next();
            System.out.println(spiService.getClass().getName() + " : " + spiService.say());
        }


        /*
         * 迭代方法2： foreach
         */
//        for (SPIService spiService : serviceLoaders) {
//            System.out.println(spiService.getClass().getName() + " : " + spiService.say());
//        }

    }

}
