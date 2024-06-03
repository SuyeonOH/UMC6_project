package umc.mission7.validation.validator;

import umc.mission7.validation.annotation.ExistPage;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PageExistValidator implements ConstraintValidator<ExistPage, Integer> {

    @Override
    public void initialize(ExistPage constraintAnnotation) {
    }

    @Override
    public boolean isValid(Integer page, ConstraintValidatorContext context) {
        if (page == null || page < 1) {
            return false;
        }
        return true;
    }
}
