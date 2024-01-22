package com.roccatagliatta.restaurant.User;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.roccatagliatta.restaurant.PasswordEncryptor.PasswordEncryptor;
import com.roccatagliatta.restaurant.User.Exceptions.InvalidUserPasswordException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
final class UserPasswordTest {

    @Mock
    private PasswordEncryptor encryptor;

    public void setup() {
        encryptor = Mockito.mock(PasswordEncryptor.class);
    }

    @Test
    void exception_is_thrown_when_password_is_invalid() {
        // Mockito.when(encryptor.encrypt(any())).thenReturn("hahaUnloved123");

        final String[] invalidPasswords = { "abc", "test1", "final", null, "easyPassword" };

        for (final String invalid : invalidPasswords) {
            assertThrows(InvalidUserPasswordException.class, () -> {
                UserPassword.fromPlain(invalid, encryptor);
            });
        }

        verify(encryptor, times(0)).encrypt(any(String.class));
    }

    @Test
    void creates_valid_password_when_password_is_valid() {
        // Mockito.when(encryptor.encrypt(any())).thenReturn("hahaUnloved123");

        final String[] validPasswords = { "validPassword123", "LowerAndUpperPlusDigit1",
                "eightMinWithDigits8", "DontExceed32Chars", "DontPutWeirdChars1" };

        for (final String valid : validPasswords) {
            assertDoesNotThrow(() -> {
                UserPassword.fromPlain(valid, encryptor);
            });
        }

        verify(encryptor, times(validPasswords.length)).encrypt(any(String.class));
    }
}
