package algorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yocn on 2019/3/8.
 * 汉诺塔
 */
public class HanoiTowerTODO {
    private List<Integer> A = new LinkedList<>();
    private List<Integer> B = new LinkedList<>();
    private List<Integer> C = new LinkedList<>();
    private int n = 3;

    public void hanoi() {
        for (int i = 0; i < n; i++) {
            A.add(i);
        }

        while (C.size() < n) {
            int top = A.get(0);
        }

    }

    private void move() {
        int moveA = A.get(0);
        if (moveA < B.get(0)) {
            B.add(moveA);
            A.remove(0);
        } else if (moveA < C.get(0)) {
            C.add(moveA);
            A.remove(0);
        }

        int moveB = B.get(0);
        if (moveB < A.get(0)) {
            A.add(moveB);
            B.remove(0);
        } else if (moveB < C.get(0)) {
            C.add(moveB);
            B.remove(0);
        }

        int moveC = C.get(0);
        if (moveC < B.get(0)) {
            B.add(moveC);
            C.remove(0);
        } else if (moveC < A.get(0)) {
            A.add(moveC);
            C.remove(0);
        }
    }

}
