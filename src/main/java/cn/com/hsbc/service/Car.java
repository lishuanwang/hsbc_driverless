package cn.com.hsbc.service;

/**
 * Car class
 *
 * @author lishuanwang
 * @date 2020/3/26
 */
public interface Car {

    /**
     * 汽车移动
     * @param command
     */
    void move(String command);

    /**
     * X坐标
     * @return
     */
    int getPositionX();

    /**
     * Y坐标
     * @return
     */
    int getPositionY();

    /**
     * 方向
     * @return
     */
    String getOrientation();
}
