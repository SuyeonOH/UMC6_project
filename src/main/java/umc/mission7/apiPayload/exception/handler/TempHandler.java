package umc.mission7.apiPayload.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import umc.mission7.apiPayload.code.BaseErrorCode;
import umc.mission7.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAllExceptions(Exception ex, WebRequest request) {
        // NullPointerException 방지
        if (ex.getMessage() == null) {
            return new ResponseEntity<>("Unknown error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        // 예외 메시지를 로깅
        System.err.println("Exception occurred: " + ex.getMessage());
        // 예외 메시지를 클라이언트에게 반환
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}