package group.foodie.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * foodie data
 * </p>
 *
 * @author renmingyuan
 * @since 2022-11-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class Foodie extends Model<Foodie> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String locationId;

    private String applicant;

    /**
     * 0-NULL 1-Truck 2-Push Cart
     */
    private Integer facilityType;

    private String locationDescription;

    private String address;

    /**
     * 0-NULL 1-APPROVED 2-REQUESTED 3-EXPIRED 4-SUSPEND 5-ISSUED 6-ONLINE
     */
    private Integer status;

    private String foodItems;

    private String latitude;

    private String longitude;

    private String zipCode;

    private Integer neighborhoods;

    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
