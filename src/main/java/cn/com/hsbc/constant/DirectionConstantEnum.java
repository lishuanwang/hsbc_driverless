package cn.com.hsbc.constant;

import lombok.ToString;

@ToString
public enum DirectionConstantEnum {

    /**
     * 东
     */
    EAST("EAST"),
    /**
     * 西
     */
    WEST("WEST"),
    /**
     * 南
     */
    SOUTH("SOUTH"),
    /**
     * 北
     */
    NORTH("NORTH");

    private String direction;
    DirectionConstantEnum(String direction) {
        this.direction=direction;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

}
