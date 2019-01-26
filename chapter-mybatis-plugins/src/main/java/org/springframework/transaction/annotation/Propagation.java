package org.springframework.transaction.annotation;

/**
 * 创  建   时  间： 2019/1/26 23:07
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 */
public enum Propagation {

    REQUIRED(0),      // 如果当前存在事务，则加入该事务；如果当前没有事务，则创建一个新的事务。
    SUPPORTS(1),      // 如果当前存在事务，则加入该事务；如果当前没有事务，则以非事务的方式继续运行。
    MANDATORY(2),     // 如果当前存在事务，则加入该事务；如果当前没有事务，则抛出异常。
    REQUIRES_NEW(3),  // 创建一个新的事务，如果当前存在事务，则把当前事务挂起。
    NOT_SUPPORTED(4), // 以非事务方式运行，如果当前存在事务，则把当前事务挂起。
    NEVER(5),         // 以非事务方式运行，如果当前存在事务，则抛出异常。
    NESTED(6);        // 如果当前存在事务，则创建一个事务作为当前事务的嵌套事务来运行；如果当前没有事务，则该取值等价于 REQUIRED 。

    private final int value;

    private Propagation(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
