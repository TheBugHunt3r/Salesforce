package dto;

import com.github.javafaker.Faker;

public class AccountFactory {

    public static Account getAccount(String ownership,String priority) {
        Faker faker = new Faker();
        return Account.builder()
                .name(faker.name().name())
                .phone(faker.phoneNumber().phoneNumber())
                .fax(faker.phoneNumber().phoneNumber())
                .website(faker.weather().description())
                .site(faker.address().country())
                .city(faker.address().city())
                .street(faker.address().streetAddress())
                .build();
    }
}
