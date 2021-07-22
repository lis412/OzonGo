package com.lis;

// https://gist.github.com/rusdevops/d85340e26aeac720c338874492adf637#file-19-md
// первый элемента подмассива ищем спомощью бинарного поиска
// сложность О(log(N)), затем последовательно перебираем элементы подмассива
// если встречаются повторяющиеся элементы, то могут возникнуть проблемы...

public class Main {

    public static void main(String[] args) {
        System.out.println(isInclude(new int[]{1, 2, 3, 5, 7, 9, 11}, new int[]{}) == true);
        System.out.println(isInclude(new int[]{1, 2, 3, 5, 7, 9, 11}, new int[]{3, 5, 7}) == true);
        System.out.println(isInclude(new int[]{1, 2, 3, 5, 7, 9, 11}, new int[]{4, 5, 7}) == false);
    }

    static int findNum(int num, int[] arr, int startPos, int endPos) {

        if (endPos >= startPos) {
            int mid = (startPos + endPos) / 2;
            if (num == arr[mid]) return mid;
            if (num > arr[mid]) return findNum(num, arr, mid+1, endPos);
            return  findNum(num, arr, startPos, mid - 1);
        }
        return -1;
    }

    static boolean isInclude(int[] array, int[] subArr) {
        if (subArr.length == 0) return true;
        int pos = findNum(subArr[0], array, 0, array.length - subArr.length - 1);
        if (pos == -1) return false;
        for (int i = 0; i < subArr.length; i++) {
            if (array[pos + i] != subArr[i]) return false;
        }
        return true;
    }
}
