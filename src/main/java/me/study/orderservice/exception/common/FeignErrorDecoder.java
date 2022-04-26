package me.study.orderservice.exception.common;

import feign.Response;
import feign.codec.ErrorDecoder;
import me.study.orderservice.exception.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class FeignErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()){
            case 400:
                if(methodKey.contains("getUserByAuth")){
                    return new FeignException(methodKey, "User Not Found", HttpStatus.valueOf(response.status()));
                }else if(methodKey.contains("minusStock")){
                    return new FeignException(methodKey, "Qty must be equal or less than Stock", HttpStatus.valueOf(response.status()));
                }
                break;
            case 404:
                if(methodKey.contains("minusStock")){
                    return new FeignException(methodKey, "Catalog Not Found", HttpStatus.valueOf(response.status()));
                }
                return new FeignException(methodKey, "API Not Found", HttpStatus.valueOf(response.status()));
            default:
                return new FeignException(methodKey, "Server error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return null;
    }
}
