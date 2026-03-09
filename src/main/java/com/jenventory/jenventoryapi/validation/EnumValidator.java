package com.jenventory.jenventoryapi.validation;

import com.jenventory.jenventoryapi.common.annotation.ValidEnum;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EnumValidator implements ConstraintValidator<ValidEnum, Object> {

    private Set<String> validationValues;
    private String readableAllowedValues;
    private boolean ignoreCase;
    private String message;

    @Override
    public void initialize(ValidEnum constraintAnnotation) {
        this.message = constraintAnnotation.message();
        this.ignoreCase = constraintAnnotation.ignoreCase();

        Stream<String> enumNameStream = Stream.of(constraintAnnotation.enumClass().getEnumConstants()).map(Enum::name);

        this.validationValues = enumNameStream
                .map(name -> ignoreCase ? name.toUpperCase() : name)
                .collect(Collectors.toSet());

        this.readableAllowedValues = Stream.of(constraintAnnotation.enumClass().getEnumConstants())
                .map(Enum::name)
                .collect(Collectors.joining(", "));
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        String input = value.toString();
        String comparisonValue = ignoreCase ? input.toUpperCase() : input;

        if (!validationValues.contains(comparisonValue)) {
            String interpolatedMessage = message.replace("${allowedValues}", this.readableAllowedValues);
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(interpolatedMessage)
                    .addConstraintViolation();

            return false;
        }

        return true;
    }

}
