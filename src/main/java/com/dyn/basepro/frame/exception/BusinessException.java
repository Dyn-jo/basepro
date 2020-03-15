package   com.dyn.basepro.frame.exception;

import com.dyn.basepro.frame.response.CodeMessage;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private String code;

    private String message;

    public BusinessException(CodeMessage cm) {
        super(cm.getMessage());
        this.code = cm.getCode();
        this.message = cm.getMessage();
    }

    public BusinessException(CodeMessage cm, Throwable cause) {
        super(cm.getMessage(), cause);
        this.code = cm.getCode();
        this.message = cm.getMessage();
    }

}
