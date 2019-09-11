package top.flygrk.ishare.springbootmongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.flygrk.ishare.springbootmongodb.dao.ExampleRepository;
import top.flygrk.ishare.springbootmongodb.entity.Example;

/**
 * @Author: flygrk
 * @Date: Created in 2019/7/4 10:50
 * @Version: 1.0
 * @Description:
 */
@RestController
public class ExampleController {

    @Autowired
    private ExampleRepository exampleRepository;

    @GetMapping("/123")
    public String save() {
        Example example = new Example();

        example.setName("123");

        exampleRepository.save(example);

        String success = "123 success";

        return success;
    }

}
