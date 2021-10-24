package ou.acs.entity;

import lombok.Data;

@Data
public class Person {
    private String company_name;
    private String people_name;
    private String people_birthday;
    private String people_passport;
    private String people_birth;
    private String access;
    private String check_datetime;
    private String subscription_number;
    private String subscription_date;

    public Person(String company_name,
                  String people_name,
                  String people_birthday,
                  String people_passport,
                  String people_birth,
                  String access,
                  String check_datetime,
                  String subscription_number,
                  String subscription_date) {
        this.company_name = company_name;
        this.people_name = people_name;
        this.people_birthday = people_birthday;
        this.people_passport = people_passport;
        this.people_birth = people_birth;
        this.access = access;
        this.check_datetime = check_datetime;
        this.subscription_number = subscription_number;
        this.subscription_date = subscription_date;
    }
}
