import com.delineneo.ModelErrorsResultMatchers;
import com.delineneo.service.SimpleService;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.easymock.EasyMock.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * User: deline
 * Date: 31/05/13
 * Time: 7:23 PM
 */


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({
        "classpath:spring/spring-mvc-config.xml",
        "classpath:spring/spring-app-config.xml",
        "classpath:test-config.xml"

})
@DirtiesContext
public class PlayerValidationWithMocksTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Autowired
    private SimpleService simpleService;


    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        expect(simpleService.getText()).andStubReturn("I've stub returned the value");
    }

    @After
    public void reset() {
        EasyMock.reset(simpleService);
    }

    @Test
    public void submitReturnsHttpOk() throws Exception {
        replayAll();
        mockMvc.perform(
            post("/player/add")
                .param("firstName", "deline")
                .param("lastName", "neo"))
            .andExpect(status().isFound())
            .andExpect(redirectedUrl("/player/1"));
        verifyAll();
    }

    @Test
    public void submitWithValidationErrors() throws Exception {
        replayAll();
        mockMvc.perform(post("/player/add"))
            .andExpect(status().isOk())
            .andExpect(model().attributeHasFieldErrors("player", "firstName", "lastName"))
            .andExpect(model().errorCount(2));
        verifyAll();
    }

    @Test
    public void errorMessagesDisplayedWhenValidationFails() throws Exception {
        replayAll();
        mockMvc.perform(post("/player/add"))
                .andExpect(modelErrors().attributeHasErrorMessageForField("player", "First name is required", "firstName"))
                .andExpect(modelErrors().attributeHasErrorMessageForField("player", "Last name is required", "lastName"));
        verifyAll();
    }

    private void verifyAll() {
        verify(simpleService);
    }

    private void replayAll() {
        replay(simpleService);
    }

    public static ModelErrorsResultMatchers modelErrors() {
        return new ModelErrorsResultMatchers();
    }
}
