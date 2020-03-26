package cn.com.hsbc.service.impl;

import cn.com.hsbc.constant.DirectionConstantEnum;
import cn.com.hsbc.domain.CarPark;
import cn.com.hsbc.domain.CarStatus;
import org.junit.Test;

public class CarImplTest {
    @Test
    public void moveTest(){
        CarStatus carStatus = new CarStatus(1,1, DirectionConstantEnum.NORTH.getDirection());
        CarPark carPark = new CarPark(4,4);
        CarImpl defaultCar = new CarImpl(carStatus, carPark);

        defaultCar.move("TURN");
        defaultCar.move("2");


        System.out.println(defaultCar.toString());
    }
}