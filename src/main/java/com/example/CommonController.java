package com.example;

import com.example.common.file.DefaultParams;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by whydd on 2017-03-01.
 */
@RestController
public class CommonController {
    @RequestMapping("/test")
    public HttpEntity<Map<String, Object>> test() throws Exception{
        Map<String, Object> resMap = new HashMap<>();
        resMap.put("a", "a");
        return new ResponseEntity<Map<String, Object>>(resMap, HttpStatus.OK);
    }

    @RequestMapping("/test/fileupload")
    public HttpEntity<Map<String, Object>> postFileUpload(DefaultParams defaultParams) throws Exception {
        Map<String, Object> resMap = new HashMap<>();

        return new ResponseEntity<Map<String, Object>>(resMap, HttpStatus.OK);
    }

}
