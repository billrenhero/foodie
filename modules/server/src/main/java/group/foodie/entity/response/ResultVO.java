package group.foodie.entity.response;

import lombok.Data;

/**
 * base response VO
 *
 * @author renmingyuan
 * @date 2022/11/25
 */
@Data
public class ResultVO<T> {

    public static final String SUCCESS_CODE = "0000";
    public static final String SUCCESS_FLAG = "S";
    public static final String FAIL_CODE = "9999";
    public static final String FAIL_FLAG = "F";

    private String retCode;
    private String retFlag;
    private T retData;

    public ResultVO(String retCode, String retFlag, T retData) {
        this.retCode = retCode;
        this.retFlag = retFlag;
        this.retData = retData;
    }

    public static <T> ResultVO<T> SUCCESS(T obj) {
        return CUSTOM(SUCCESS_CODE, SUCCESS_FLAG, obj);
    }

    public static <T> ResultVO<T> FAIL() {
        return CUSTOM(FAIL_CODE, FAIL_FLAG, null);
    }

    public static <T> ResultVO<T> CUSTOM(String retCode, String retFlag, T retData) {
        return new ResultVO<>(retCode, retFlag, retData);
    }
}
