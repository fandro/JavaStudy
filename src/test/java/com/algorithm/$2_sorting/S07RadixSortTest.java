package com.algorithm.$2_sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODO
 *
 * @author fuwb
 * @date 2021-02-09
 */
class S07RadixSortTest {

    @Test
    void radixSortTest() {
        int[] array = {1852536447, 1776054315, 1372107212, 1584359267, 1307630825,
                1867213250, 1775843693, 1587420413, 1767421664, 1565039430,
                1995628837, 1329996258, 1833763808, 1710895133, 1595045420,
                1598156160, 1594125315, 1551421576, 1823061824, 1332161564
        };
        int[] expectedArray = new int[]{1852536447, 1776054315, 1372107212, 1584359267, 1307630825,
                1867213250, 1775843693, 1587420413, 1767421664, 1565039430,
                1995628837, 1329996258, 1833763808, 1710895133, 1595045420,
                1598156160, 1594125315, 1551421576, 1823061824, 1332161564
        };

        S07RadixSort radixSort = new S07RadixSort();

        radixSort.radixSort(array);

    }
}