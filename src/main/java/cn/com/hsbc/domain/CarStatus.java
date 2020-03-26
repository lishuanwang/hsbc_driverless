package cn.com.hsbc.domain;

import cn.com.hsbc.constant.DirectionConstantEnum;
import lombok.*;

/**
 * CarPosition class
 *
 * @author lishuanwang
 * @date 2020/3/26
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CarStatus {

        private int positionX;

        private int positionY;

        private String direction;

}
