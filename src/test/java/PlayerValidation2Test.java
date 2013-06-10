import com.delineneo.service.PlayerService;
import com.delineneo.service.SimpleService;
import com.delineneo.web.controller.AddPlayerController;
import com.delineneo.web.form.Player;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.SpringConstraintValidatorFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.easymock.EasyMock.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * User: deline
 * Date: 31/05/13
 * Time: 7:23 PM
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = PlayerValidation2Test.PlayerValidationTestConfig.class)
@DirtiesContext
public class PlayerValidation2Test {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;
    private PlayerService playerService;

    @Before
    public void setup() {

        playerService = createMock(PlayerService.class);

        LocalValidatorFactoryBean localValidatorFactory = new LocalValidatorFactoryBean();
        localValidatorFactory.setConstraintValidatorFactory(new SpringConstraintValidatorFactory(wac.getAutowireCapableBeanFactory()));

        AddPlayerController addPlayerController = new AddPlayerController();
        addPlayerController.setPlayerService(playerService);

        mockMvc = MockMvcBuilders.standaloneSetup(addPlayerController).setValidator(localValidatorFactory).build();
    }

    @Test
    public void submitReturnsHttpOk() throws Exception {

        SimpleService simpleService = wac.getBean("simpleService", SimpleService.class);
        expect(simpleService.getText()).andStubReturn("deline and matthew");
        expect(playerService.save(anyObject(Player.class))).andReturn(1);

        EasyMock.replay(simpleService, playerService);
        mockMvc.perform(
                post("/player/add")
                        .param("firstName", "deline")
                        .param("lastName", "neo"))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/player/1"));
        EasyMock.verify(simpleService, playerService);
    }

    @Configuration
    @EnableWebMvc
    public static class PlayerValidationTestConfig {

        @Bean
        public SimpleService simpleService() {
            return createMock("simpleServiceMock", SimpleService.class);
        }
    }
}
