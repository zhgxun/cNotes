package com.github.zhgxun.learn.common.event;

import lombok.Data;

/**
 * 支付相关的消息
 */
@Data
public class Pay {
    private int id;
    private double amount;
}
