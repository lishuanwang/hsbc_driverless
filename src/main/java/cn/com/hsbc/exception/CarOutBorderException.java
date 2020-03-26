package cn.com.hsbc.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * CarOutBorderException class
 *
 * @author lishuanwang
 * @date 2020/3/26
 */
@Slf4j
public class CarOutBorderException extends RuntimeException {

    public CarOutBorderException(){
        log.error("汽车越界异常");
    }
}
