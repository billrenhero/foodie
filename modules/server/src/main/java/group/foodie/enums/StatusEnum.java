package group.foodie.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Status Enum
 *
 * @author renmingyuan
 * @date 2022/11/25
 */
@Getter
@AllArgsConstructor
public enum StatusEnum {

    NONE("", 0),
    APPROVED("APPROVED", 1),
    REQUESTED("REQUESTED", 2),
    EXPIRED("EXPIRED", 3),
    SUSPEND("SUSPEND", 4),
    ISSUED("ISSUED", 5),
    ONLINE("ONLINE", 6);

    private final String status;
    private final int num;

    public static int getNums(String status) {
        for (StatusEnum s : StatusEnum.values()) {
            if (s.status.equals(status)) {
                return s.num;
            }
        }
        return NONE.num;
    }
}
