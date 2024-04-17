package com.example.realtimestreaming.Common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto<T> {
    private T data;

    public static <T> ResponseEntity<ResponseDto<T>> ok(T data) {
        return ResponseEntity.ok(new ResponseDto<T>(data));
    }
    public static <T> ResponseEntity<ResponseDto<T>> created(T data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto<T>(data));
    }
}
