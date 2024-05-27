package umc.mission7.apiPayload.exception.handler;

import umc.mission7.apiPayload.code.BaseErrorCode;
import umc.mission7.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
