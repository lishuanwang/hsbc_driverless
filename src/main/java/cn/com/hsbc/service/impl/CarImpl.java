package cn.com.hsbc.service.impl;

import cn.com.hsbc.constant.DirectionConstantEnum;
import cn.com.hsbc.domain.CarPark;
import cn.com.hsbc.domain.CarStatus;
import cn.com.hsbc.exception.CarOutBorderException;
import cn.com.hsbc.service.Car;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * CarImpl class
 *
 * @author lishuanwang
 * @date 2020/3/26
 */
@Slf4j
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CarImpl implements Car {

    private CarStatus carStatus;

    private CarPark carPark;


    @Override
    public void move(String command) {
        int i = validParam(command);
        if (i == 0) {
            throw new IllegalArgumentException();
        }
        if ("TURN".equals(command.toUpperCase())) {
            turnAround(command);
        } else {
            int step = Integer.parseInt(command);
            switch (carStatus.getDirection()) {
                case "EAST":
                    carStatus.setPositionX(carStatus.getPositionX() + step);
                    break;
                case "WEST":
                    carStatus.setPositionX(carStatus.getPositionX() - step);
                    break;
                case "SOUTH":
                    carStatus.setPositionY(carStatus.getPositionY() - step);
                    break;
                case "NORTH":
                    carStatus.setPositionY(carStatus.getPositionY() + step);
                    break;
                default:
                    break;
            }
        }
        if (checkParkBorder()) {
            throw new CarOutBorderException();
        }

    }

    @Override
    public int getPositionX() {
        return carStatus.getPositionX();
    }

    @Override
    public int getPositionY() {
        return carStatus.getPositionY();
    }

    @Override
    public String getOrientation() {
        return carStatus.getDirection();
    }

    /**
     * 检验参数
     *
     * @param command
     * @return
     */
    private int validParam(String command) {
        try {
            if ("TURN".equals(command.toUpperCase())) {
                return 1;
            } else {
                Integer.parseInt(command);
                return 1;
            }
        } catch (Exception e) {
            log.error("参数不合法：{}", command, e.getMessage(), e);
            return 0;
        }
    }


    /**
     * 检查是否越界
     */
    private boolean checkParkBorder() {
        int carPositionX = carStatus.getPositionX();
        int carPositionY = carStatus.getPositionY();
        int parkWidth = carPark.getWidth();
        int parkHeight = carPark.getHeight();
        boolean carX = carPositionX > parkWidth || carPositionX < 0;
        boolean carY = carPositionY > parkHeight || carPositionY < 0;
        if (carX && carY) {
            log.error("car的x坐标和y坐标都超过了停车场的边界");
            return true;
        }
        if (carX) {
            log.error("car的x坐标超过了停车场的边界");
            return true;
        }
        if (carY) {
            log.error("car的y坐标超过了停车场的边界");
            return true;
        }
        return false;
    }


    public void turnAround(String command) {
        switch (carStatus.getDirection()) {
            case "EAST":
                carStatus.setDirection(DirectionConstantEnum.SOUTH.getDirection());
                break;
            case "WEST":
                carStatus.setDirection(DirectionConstantEnum.NORTH.getDirection());
                break;
            case "SOUTH":
                carStatus.setDirection(DirectionConstantEnum.WEST.getDirection());
                break;
            case "NORTH":
                carStatus.setDirection(DirectionConstantEnum.EAST.getDirection());
                break;
            default:
                break;
        }
    }

}
