package kr.co.oreb.algorithm.chapter09.dto;

import kr.co.oreb.algorithm.Description;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Edge {

    @Description("대상 노드번호")
    public int to;

    @Description("to 까지의 거리")
    public int weight;


}
