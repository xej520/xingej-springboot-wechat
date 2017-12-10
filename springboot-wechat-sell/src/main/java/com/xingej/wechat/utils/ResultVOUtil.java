package com.xingej.wechat.utils;

import com.xingej.wechat.vo.ResultVO;

/**
 * 针对ResultVO的工具类，
 * 
 * 避免，每次创建
 * 
 * @author erjun 2017年12月11日 上午6:12:44
 */
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO<Object> resultVO = new ResultVO<Object>();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMessge("成功");
        return resultVO;
    }

    public static ResultVO<?> success() {
        return success(null);
    }

    public static ResultVO<Object> error(Integer code, String msg) {
        ResultVO<Object> resultVO = new ResultVO<Object>();
        resultVO.setCode(code);
        resultVO.setMessge(msg);
        return resultVO;
    }
}
