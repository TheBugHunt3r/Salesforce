package dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Account {
    private String name;
    private String phone;
    private String fax;
    private String website;
    private String site;
    private String city;
    private String street;
    private String ownership;
    private String priority;
}
