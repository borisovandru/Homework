package ru.geekbrains.algorithmjava.lesson5;

import java.util.HashMap;

public class RecursionManager {
    public RecursionManager() {
    }

    public boolean isLinealDescendant(String des, String ans, HashMap<String, String[]> dic) {
        boolean answer = false;
        if (!dic.containsKey(des) && !dic.containsKey(ans)) {
            return false;
        } else if (dic.containsKey(des) && dic.get(des).length > 0) {
            String[] parents = dic.get(des);
            for (String parent : parents) {
                if (parent.equals(ans)) {
                    return true;
                }
            }
            for (String parent : parents) {
                answer = isLinealDescendant(parent, ans, dic);
                if (answer) {
                    break;
                }
            }
        }
        return answer;
    }

    public void mayBeInternal(int start, int stop) {
        System.out.println(start);
        if (start == stop + 1) {
            return;
        }
        mayBeInternalCycle(++start, stop);
    }

    public void mayBeInternalCycle(int start, int stop) {
        while (start != stop + 1) {
            System.out.println(start);
            start++;
        }
    }
}
