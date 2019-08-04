package com.opendragonhuang.list.example;

import com.opendragonhuang.list.adt.MyList;
import com.opendragonhuang.list.implement.MyArrayList;

/**
 * @author opendragonhuang
 * @version 1.0
 * @date 2019/8/3
 */
public class Lists {
    /**
     * 合并两个有序线性表，返回一个新的有序线性表。
     *
     * @param list1
     * @param list2
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> MyList<T> MergeList(MyList<T> list1, MyList<T> list2) {
        MyList<T> list = new MyArrayList<>();

        int i = 1;
        int j = 1;
        T e1;
        T e2;
        while (i <= list1.length() && j <= list2.length()) {
            e1 = list1.getElem(i);
            e2 = list2.getElem(i);

            if (e1.compareTo(e2) < 0) {
                list.insert(list.length() + 1, e1);
                i++;
            } else if (e1.compareTo(e2) == 0) {
                list.insert(list.length() + 1, e1);
                i++;
                j++;
            } else if (e1.compareTo(e2) > 0) {
                list.insert(list.length() + 1, e2);
                j++;
            }
        }

        while (i <= list1.length()) {
            e1 = list1.getElem(i);
            list.insert(list.length() + 1, e1);
            i++;
        }

        while (j <= list2.length()) {
            e2 = list2.getElem(j);
            list.insert(list.length() + 1, e2);
            j++;
        }

        return list;
    }

    /**
     * 求 list1 和 list2 的并集。
     * @param list1
     * @param list2
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> MyList<T> UnionList(MyList<T> list1, MyList<T> list2) {
        MyList<T> list = list1.clone();

        T e = null;
        for (int i = 1; i <= list2.length(); i++) {
            e = list2.getElem(i);
            if (list.locateElem(e) == 0) {
                list.insert(list.length() + 1, e);
            }
        }

        return list;
    }

    /**
     * 求 (list1 - list2)U(list2 - list1)
     * @param list1
     * @param list2
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> MyList<T> difference(MyList<T> list1, MyList<T> list2){
        MyList<T> list = list1.clone();

        int i = 0;
        for (T t : list2) {
            i = list.locateElem(t);
            if(i == 0){
                list.insert(list.length()+1, t);
            }else{
                list.delete(i);
            }
        }

        return list;
    }
}