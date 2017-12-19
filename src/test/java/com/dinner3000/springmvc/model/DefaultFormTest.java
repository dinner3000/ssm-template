package com.dinner3000.springmvc.model;

import com.dinner3000.BaseTest;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class DefaultFormTest extends BaseTest {

    @Test
    public void validationTest() throws Exception {
        DefaultForm defaultForm = new DefaultForm();

        defaultForm.setName("name");
        defaultForm.setValue(10);

        assertEquals("name", defaultForm.getName());
        assertEquals(10, defaultForm.getValue());

        Set<ConstraintViolation<DefaultForm>> constraintViolations =
                validator.validate( defaultForm );
        assertEquals(2, constraintViolations.size());

    }

}