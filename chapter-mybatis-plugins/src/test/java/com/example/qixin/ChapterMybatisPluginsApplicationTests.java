package com.example.qixin;

import com.example.qixin.entity.UserInfo;
import com.example.qixin.service.UserInfoService;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ChapterMybatisPluginsApplication.class)
public class ChapterMybatisPluginsApplicationTests {

	@Autowired
	private UserInfoService userInfoService;

	@Test
	public void contextLoads() {
		log.info("------------start-----------------"+userInfoService);
		UserInfo user = new UserInfo();
		user.setAge(30);
		user.setName("qixin");
		user.setCreateTime(new Date());
		int result = userInfoService.save(user);
		log.info(result+"------------end-----------------"+user.getId());
	}

}

