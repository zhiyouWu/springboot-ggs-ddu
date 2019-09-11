package top.flygrk.ishare.springbootkafka.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * @Author: flygrk
 * @Date: Created in 2019/7/5 15:17
 * @Version: 1.0
 * @Description:
 */
public class Result implements Serializable {
    private static final long serialVersionUID = -3948389268046368059L;

    private static final Logger logger = LoggerFactory.getLogger(Result.class);

    private String status;

    private Object data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String error;

    public Result() {}

    public Result(String status, Object data) {
        this.status = status;
        this.data = data;
    }

    public Result(String status, Object data, String error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public static Result success() {
        Result result = new Result();
        result.setStatus(ResultStatusConstants.SUCCESS);
        return result;
    }

    public static Result success(Object data) {
        Result result = success();
        result.setData(data);
        return result;
    }

    public static Result failure() {
        Result result = new Result();
        result.setStatus(ResultStatusConstants.ERROR);
        return result;
    }

    public static Result failure(Object data) {
        Result result = failure();
        result.setData(data);
        return result;
    }

    public static Result failure(Object data, String error) {
        Result result = failure(data);
        result.setError(error);
        return result;
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
