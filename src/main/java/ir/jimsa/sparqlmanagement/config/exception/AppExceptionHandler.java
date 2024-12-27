package ir.jimsa.sparqlmanagement.config.exception;

import ir.jimsa.sparqlmanagement.ws.model.dto.ResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class AppExceptionHandler {

    @ExceptionHandler(value = AppServiceException.class)
    public ResponseEntity<ResponseDto> handleAppServiceExceptions(AppServiceException ex, HttpServletRequest webRequest) {
        log.error("{} : {}", "AppServiceExceptions", ex.getMessage());
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("message", ex.getMessage());
        hashMap.put("path", String.format("%s %s", webRequest.getMethod(), webRequest.getRequestURI()));
        return ResponseEntity
                .status(ex.getHttpStatus())
                .body(
                        ResponseDto.builder()
                                .action(false)
                                .timestamp(LocalDateTime.now())
                                .result(hashMap)
                                .build()
                );
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ResponseDto> handleExceptions(Exception ex, HttpServletRequest webRequest) {
        log.error("{} : {}", "App5XXException", ex.getMessage());
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("message", ex.getMessage());
        hashMap.put("path", String.format("%s %s", webRequest.getMethod(), webRequest.getRequestURI()));
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(
                        ResponseDto.builder()
                                .action(false)
                                .timestamp(LocalDateTime.now())
                                .result(hashMap)
                                .build()
                );
    }

}
