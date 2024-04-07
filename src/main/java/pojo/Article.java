package pojo;


import lombok.Data;

import java.io.Serializable;

import java.util.Date;


/**
* 文章
* @TableName Article
*/
@Data
public class Article implements Serializable {

    /**
    * id
    */
    private Long artid;

    /**
    * 标题
    */
    private String title;

    /**
    * 内容
    */
    private String content;

    /**
    * 点赞数
    */
    private Integer thumbNum;

    /**
    * 收藏数
    */
    private Integer favourNum;

    /**
    * 创建用户 id
    */
    private Long uid;

    /**
    * 创建时间
    */
    private Date publicTime;

    /**
    * 是否删除
    */
    private Integer isDelete;


}
