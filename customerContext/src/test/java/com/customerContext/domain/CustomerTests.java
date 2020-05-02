package com.customerContext.domain;

import com.customerContext.domain.customer.*;
import com.customerContext.domain.customer.exceptions.AgeConnotBeloweighteenException;
import com.customerContext.domain.customer.exceptions.InitialDepositCannotBelowAHundred;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.*;

public class CustomerTests {


    @Test
    public void should_create_age_above_eighteen() throws AgeConnotBeloweighteenException {
        Age age = new Age(19);

        assertThat(age).isNotNull();
        assertThat(age.getValue()).isEqualTo(19);
    }

    @Test
    public void should_throw_age_below_eighteen() {

        assertThatExceptionOfType(AgeConnotBeloweighteenException.class)
                .isThrownBy(() -> {
                    Age age = new Age(16);
                });
    }

    @Test
    public void should_create_customer() throws Exception {
        //Arrange
        CustomerId fakeID = CustomerId.generate();
        AccountNumber fakeNumber = AccountNumber.generate();
        Money fakeMoney = new Money(500);

        CustomerPolicy fakePolicy = Mockito.mock(CustomerPolicy.class);

        Mockito.when(fakePolicy.calculate(fakeMoney)).thenReturn(new InterestRate(1));

        // Act
        Customer customer = Customer.create(fakeID, new Email("edasdasd@gmail.com"),
                fakeNumber,
                new Age(19),
                fakeMoney,
                fakePolicy);

        //Assertion
        assertThat(customer).isNotNull();

        assertThat(customer.getAge().getValue()).isEqualTo(19);
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 20, 50})
    public void should_throw_initial_deposit_when_customer_create(int money) throws Exception {
        //Arrange
        CustomerId fakeID = CustomerId.generate();
        AccountNumber fakeNumber = AccountNumber.generate();
        Money fakeMoney = new Money(money);
        CustomerPolicy fakePolicy = Mockito.mock(CustomerPolicy.class);


        Mockito.doThrow(new InitialDepositCannotBelowAHundred(money)).when(fakePolicy).apply(fakeMoney);

        //Assertion
        assertThatThrownBy(() -> {
            Customer.create(fakeID, new Email("edasdasd@gmail.com"),
                    fakeNumber,
                    new Age(19),
                    fakeMoney,
                    fakePolicy);
        }).isInstanceOf(InitialDepositCannotBelowAHundred.class);
    }

    //TODO: 3 account max test yap
}
