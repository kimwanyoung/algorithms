package lib.유니온파인드;

import java.util.Arrays;

public class UnionFind {

    private static int[] parent;
    public static void main(String[] args) {
        parent = new int[6];
        for(int i = 0; i < 6; i++) {
            parent[i] = i;
        }

        union(1, 2);
        System.out.println(Arrays.toString(parent));
        union(3, 4);
        System.out.println(Arrays.toString(parent));
        union(3, 5);
        System.out.println(Arrays.toString(parent));
        System.out.println("find(4) : " + find(4));
        System.out.println("find(2) : " + find(2));
        union(2, 4);
        System.out.println(Arrays.toString(parent));
        System.out.println("find(4) : " + find(4));
    }

    private static boolean union(int x, int y) {
        x = find(x); //x의 부모 노드 찾기
        y = find(y); //y의 부모 노드 찾기

        //이미 같다면 false
        if(x == y) return false;

        // 작은 쪽이 부모 노드
        if(x <= y) parent[y] = x;
        else parent[x] = y;
        return true;
    }

    private static int find(int x) {
        if(parent[x] == x) return x;
        return find(parent[x]);
    }
}
