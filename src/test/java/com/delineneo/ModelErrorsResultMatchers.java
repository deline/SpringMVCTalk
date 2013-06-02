package com.delineneo;

import org.apache.commons.lang3.StringUtils;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.assertThat;

/**
 * User: deline
 * Date: 31/05/13
 * Time: 8:01 PM
 */
public class ModelErrorsResultMatchers {

    public ResultMatcher attributeHasErrorMessageForField(final String attribute, final String expectedErrorMessage, final String field) {
        return new ResultMatcher() {
            @Override
            public void match(MvcResult result) throws Exception {
                ModelAndView modelAndView = result.getModelAndView();
                BindingResult bindingResult = (BindingResult) modelAndView.getModel().get(BindingResult.MODEL_KEY_PREFIX + attribute);
                List<ObjectError> allErrors = bindingResult.getAllErrors();
                
                assertThat(allErrors.isEmpty(), is(false));
                assertThat(allErrors, hasItem(errorMessageForField(expectedErrorMessage, field)));
            }

            private TypeSafeMatcher<FieldError> errorMessageForField(final String expectedErrorMessage, final String field) {
                return new TypeSafeMatcher<FieldError>() {
                    @Override
                    protected boolean matchesSafely(FieldError item) {
                        return StringUtils.equals(item.getField(), field) && StringUtils.equals(item.getDefaultMessage(), expectedErrorMessage);
                    }

                    @Override
                    public void describeTo(Description description) {
                        description.appendText("Error message: " + expectedErrorMessage + " for field: " + field);
                    }
                };
            }
        };
    }
}
