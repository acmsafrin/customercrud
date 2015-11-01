package com.mycompany.myproject.service;

import com.mycompany.myproject.config.JPAConfig;
import com.mycompany.myproject.config.ServiceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import com.mycompany.myproject.persist.entity.Customer;
import com.mycompany.myproject.service.dto.CustomerDto;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {JPAConfig.class, ServiceConfig.class})
public class GenericServiceTest {

    //@Autowired
  //  private GenericService<Customer, CustomerDto, Long> userService;

//	@Test
//	public void testFindOneUser() {
//		UserDto userDto = userService.findOne(1L);
//		Assert.assertNotNull(userDto);
//		Assert.assertEquals(1, userDto.getId().longValue());
//	}
  //  @Test
//    public void testFindAll() {
//        List<CustomerDto> authorities = userService.findAll();
//        System.out.println("LLLLE " + authorities.size());
//        Assert.assertFalse(authorities.isEmpty());
//    }

//	@Test
//    public void testSave() {
//        AuthorityDto authorityDto = new AuthorityDto();
//        authorityDto.setName("test authority");
//        authorityService.save(authorityDto);
//    }
}
