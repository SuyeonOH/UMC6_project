package umc.mission7.apiPayload.exception.handler;

import umc.mission7.apiPayload.code.BaseErrorCode;
import umc.mission7.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
