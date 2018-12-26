package com.xuningxin.utils;

import com.xuningxin.utils.rel.ApiEnum;
import com.xuningxin.utils.rel.ResultMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UtilsApplicationTests {

	@Test
	public void contextLoads() {


//		String str = DateHandler.formatDateToString(new Date(),DateHandler.DateFormat.CHINESE_DATE_FORMATER);

        Result r = new Result(ApiEnum.API_ERROR);

		System.out.println("str : " + r.toString());


	}

}

