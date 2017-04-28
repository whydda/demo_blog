package com.example;

import com.example.blog.vo.DefaultParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by whydd on 2017-03-01.
 */
@RestController
public class CommonController {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @RequestMapping("/test")
    public HttpEntity<Map<String, Object>> test(DefaultParams defaultParams, Map<String, Object> resMap) throws Exception{

        /**
         * return this.template.queryForObject(UserSearchSqlMap.selUserName(), new MapSqlParameterSource("userSeq", userSeq), (rs, rowNum) -> rs.getString("user_name"));
         * return this.template.query(UserSearchSqlMap.selUserInfoByGroupSeq(), param, new BeanPropertyRowMapper<>(UserInfo.class));
         */
        resMap.put("H2 DB VERSION", namedParameterJdbcTemplate.queryForObject("SELECT 'whydda' AS  USER_ID, '1234' AS  PASS_WD  FROM DUAL", new MapSqlParameterSource("userId", String.valueOf(defaultParams.getMap().get("userId"))), (rs, rowNum) -> rs.getString("USER_ID")));

        return new ResponseEntity<Map<String, Object>>(resMap, HttpStatus.OK);
    }

    @RequestMapping("/test/fileupload")
    public HttpEntity<Map<String, Object>> postFileUpload(DefaultParams defaultParams, Map<String, Object> resMap) throws Exception {
        resMap.put("test","test");
        return new ResponseEntity<Map<String, Object>>(resMap, HttpStatus.OK);
    }

}
