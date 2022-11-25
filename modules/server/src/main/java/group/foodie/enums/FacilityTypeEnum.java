package group.foodie.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * FacilityType Enum
 *
 * @author renmingyuan
 * @date 2022/11/25
 */
@Getter
@AllArgsConstructor
public enum FacilityTypeEnum {

    NONE("", 0),
    TRUCK("Truck", 1),
    PUSH_CART("Push Cart", 2);

    private final String type;
    private final int num;

    public static int getNums(String type) {
        for(FacilityTypeEnum t : FacilityTypeEnum.values()) {
            if (t.type.equals(type)) {
                return t.num;
            }
        }
        return NONE.num;
    }
}
