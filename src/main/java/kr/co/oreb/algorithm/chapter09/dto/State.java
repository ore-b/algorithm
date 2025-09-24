package kr.co.oreb.algorithm.chapter09.dto;

import kr.co.oreb.algorithm.Description;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class State implements Comparable<State> {

    @Description("node")
    public int node;

    @Description("start 에서 node 까지의 누적거리")
    public int dist;

    @Override
    public int compareTo(State o) {

        if (this.dist < o.dist) {
            //this 가 거리가 짧다면 this 우선
            return -1;
        }

        if (this.dist > o.dist) {
            //o 가 거리가 짧다면 o 우선
            return 1;
        }

        //둘다 거리가 같다면, 노드 번호가 작은 것 우선
        return node - o.node;
    }
}
