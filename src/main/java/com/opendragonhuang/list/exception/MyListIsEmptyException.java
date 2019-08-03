package com.opendragonhuang.list.exception;

import java.io.Serializable;

/**
 * @author opendragonhuang
 * @version 1.0
 * @date 2019/8/3
 */
public class MyListIsEmptyException extends RuntimeException implements Serializable {
    private final static long serialVersionUID = 1L;

    public MyListIsEmptyException() {
    }

    public MyListIsEmptyException(String message) {
        super(message);
    }
}
