package com.t.core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author tb
 * @date 2018/12/18 16:45
 */
@Getter
@Setter
@AllArgsConstructor
public class Pair<K,V> {

    private K key;
    private V value;
}
