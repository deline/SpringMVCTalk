package com.delineneo.web.validation;

import com.delineneo.service.SimpleService;
import com.delineneo.web.form.Player;
import org.easymock.EasyMock;
import org.easymock.EasyMockSupport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.SpringConstraintValidatorFactory;
import org.springframework.web.context.WebApplicationContext;

import javax.validation.Validator;

import static org.easymock.EasyMock.expect;

/**
 * User: deline
 * Date: 6/06/13
 * Time: 7:19 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:test-config.xml")
public class MyCustomConstraintValidatorTest extends EasyMockSupport {

    @Autowired
    private WebApplicationContext wac;

    @Test
    public void canMockTheService() {

        SimpleService simpleService = wac.getBean(SimpleService.class);
        LocalValidatorFactoryBean localValidatorFactory = new LocalValidatorFactoryBean();
        localValidatorFactory.setConstraintValidatorFactory(new SpringConstraintValidatorFactory(wac.getAutowireCapableBeanFactory()));
        localValidatorFactory.afterPropertiesSet();

        Validator validator = localValidatorFactory.getValidator();

        expect(simpleService.getText()).andStubReturn("Attempt 3");

        EasyMock.replay(simpleService);
        validator.validate(createPersonForm());
        EasyMock.verify(simpleService);


    }


    private Player createPersonForm() {
        return new Player();
    }

}
