package com.kimzing.test.domain.dto;

import com.kimzing.test.domain.vo.GenderEnum;
import lombok.Builder;
import lombok.Data;

/**
 * 用户信息实体.
 *
 * @author KimZing - kimzing@163.com
 * @since 2019/12/28 12:52
 */
@Data
@Builder
public class UserDTO {

    private Long id;

    private String username;

    private String nickname;

    private Integer age;

    private GenderEnum gender;

}
