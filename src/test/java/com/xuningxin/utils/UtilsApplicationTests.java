package com.xuningxin.utils;

import com.alibaba.fastjson.JSONObject;
import com.xuningxin.utils.web.WebUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UtilsApplicationTests {

	@Test
	public void contextLoads() throws Exception{


//		String str = DateHandler.formatDateToString(new Date(),DateHandler.DateFormat.CHINESE_DATE_FORMATER);

//        Result r = new Result(ApiEnum.API_ERROR);

//		System.out.println("str : " + r.toString());

		String result = WebUtils.doGet("http://127.0.0.1:8081/api/update/basic");

		System.out.println(result);

		JSONObject params = new JSONObject();
		params.put("id","1");

		String result2 = WebUtils.doPost("http://127.0.0.1:8081/api/activity/detail",params.toJSONString());
		System.out.println(result2);


	}

}

