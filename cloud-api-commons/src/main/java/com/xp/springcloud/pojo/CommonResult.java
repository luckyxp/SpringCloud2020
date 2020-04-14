package com.xp.springcloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Climb.Xu
 * @date 2020/4/8 1:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String messesge;
    private T data;

    public CommonResult(Integer code, String messesge) {
        this(code, messesge, null);
    }
}
