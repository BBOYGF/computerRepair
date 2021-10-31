package com.computer_repair.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author guofan
 * @since 2021-10-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Order对象")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "订单名称")
    private String name;

    @ApiModelProperty(value = "创建时间")
    @TableField("createTime")
    private LocalTime createtime;

    @ApiModelProperty(value = "订单数量")
    private Integer quantity;


}
