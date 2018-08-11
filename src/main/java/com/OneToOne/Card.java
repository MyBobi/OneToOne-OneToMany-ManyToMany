package com.OneToOne;

import java.io.Serializable;

/**
 * Created by 吴俊俏
 * Date: 2018/8/8 0008
 * Time: 18:28
 */
public class Card implements Serializable {

    private Integer id;  // 主键id
    private String code; // 身份证编号

    public Card() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    @Override
    public String toString() {
        return "Card [id=" + id + ", code=" + code + "]";
    }


}
