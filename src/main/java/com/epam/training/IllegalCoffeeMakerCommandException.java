package com.epam.training;

/**
 * Created by Dmytro_Ulanovych on 10/7/2015.
 */
public class IllegalCoffeeMakerCommandException extends Error {
    public IllegalCoffeeMakerCommandException() {
    }

    public IllegalCoffeeMakerCommandException(String message) {
        super(message);
    }

    public IllegalCoffeeMakerCommandException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalCoffeeMakerCommandException(Throwable cause) {
        super(cause);
    }

    public IllegalCoffeeMakerCommandException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
