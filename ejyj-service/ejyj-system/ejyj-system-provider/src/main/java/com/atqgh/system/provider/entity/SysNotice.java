package com.atqgh.system.provider.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;

/**
 * 通知公告表.
 *
 * @author Mubai
 * @date 2022-08-14 10:45:23
 */
@Data
@TableName("sys_notice")
public class SysNotice implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 公告ID.
     */
    @TableId
    private Integer id;

    /**
     * 公告标题.
     */
    private String noticeTitle;

    /**
     * 公告类型（1通知 2公告）.
     */
    private String noticeType;

    /**
     * 公告内容.
     */
    private String noticeContent;

    /**
     * 公告状态（0正常 1关闭）.
     */
    private String status;

    /**
     * 创建者.
     */
    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    /**
     * 创建时间.
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新者.
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

    /**
     * 更新时间.
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 备注.
     */
    private String remark;

}
