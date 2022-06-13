/*用于接收各种杂类post方法的body*/

package edu.zju.se.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
public class GetPost {

    private List<String> readlist;

//    public GetPost(){}

}
