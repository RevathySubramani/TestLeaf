package simpletest;

import java.util.Date;

import com.github.javafaker.Faker;

public class DynamicData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Faker fake = new Faker();
		String firstName = fake.name().firstName();
		System.out.println(firstName);
		Date birthday = fake.date().birthday();
		System.out.println(birthday);
		String emailAddress = fake.internet().emailAddress();
		System.out.println(emailAddress);

	}

}
