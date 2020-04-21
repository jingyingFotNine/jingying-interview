package com.jingying.leetcode.base.datastructrue.lruCache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 用 linkendHashMap 实现一个 lru cache
 *
 * 思路: 利用linkedHashMap 中维护的每个 元素入map时的次序
 *      这个规则可在 构造函数的时候指定读算不算一次访问cache
 *      如果算访问 cache 在 get 执行的时候 会将这次get的key 置为最后访问的元素 放置链表尾部
 *      如果不算访问cache 在get(key) 之后 访问次序不会改变
 *
 * author by beijita@weilaicheng.com
 * 2020/4/19
 *
 * @author xiangzhi.meng
 */
public class LRUCache extends LinkedHashMap<Integer,Integer> {


    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > 2;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache();
        for (int i = 1; i<4 ;i++){
            lruCache.put(i,i);
            System.out.println(lruCache);
        }
    }
}
