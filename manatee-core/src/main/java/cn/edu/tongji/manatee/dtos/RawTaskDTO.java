package cn.edu.tongji.manatee.dtos;

import cn.edu.tongji.manatee.enumerate.RequestType;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by xubing on 13:23 for manatee.
 * <p>
 * I love coding forever
 *
 *
 */

public class RawTaskDTO implements Serializable {

    private String taskName;

    private String url;

    private HashMap<String, String> data;

    private HashMap<String, String> headers;

    private RequestType requestType;

    private String signature;

    private Long prior;



}
