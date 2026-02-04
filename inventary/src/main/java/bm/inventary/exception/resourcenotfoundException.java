package bm.inventary.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class resourcenotfoundException extends RuntimeException{

    public resourcenotfoundException(String massage){
        super(massage);
    }


}
