package com.demoqa.tests;

import com.demoqa.pages.PracticeFormPage;
import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;


public class PracticeFormWithJavaFakerTests extends TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();
    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userGender = "Female",
            userNumber = faker.number().digits(10),
            userSubject = "Hindi",
            userHobbies = "Reading",
            userPicture = "testPicture.jpg",
            picturePath = "src/test/resources/img/" + userPicture,
            currentAddress = faker.address().fullAddress(),
            userState = "Haryana",
            userCity = "Karnal";

    @Test
    @Description(value = "Тест проверяет форму регистрации студента")
    void formTests() {

        practiceFormPage.openPage();
        practiceFormPage.typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(userEmail);
        practiceFormPage.selectGender(userGender);
        practiceFormPage.typeMobilePhone(userNumber);
        practiceFormPage.calendar.setDate("13", "July", "2000");
        practiceFormPage.selectSubject.click();
        practiceFormPage.selectSubjects(userSubject);
        practiceFormPage.selectHobbies(userHobbies);
        practiceFormPage.uploadPicture(picturePath);
        practiceFormPage.typeCurrentAdress(currentAddress);
        practiceFormPage.selectStateLocator.click();
        practiceFormPage.selectState(userState);
        practiceFormPage.selectCityLocator.click();
        practiceFormPage.selectCity(userCity);
        practiceFormPage.submitData();
        practiceFormPage.checkTitleResults()
                .checkResultValue("Student Name", firstName + " " + lastName)
                .checkResultValue("Student Email", userEmail)
                .checkResultValue("Gender", userGender)
                .checkResultValue("Mobile", userNumber)
                .checkResultValue("Date of Birth", "13 July,2000")
                .checkResultValue("Subjects", userSubject)
                .checkResultValue("Hobbies", userHobbies)
                .checkResultValue("Picture", userPicture)
                .checkResultValue("Address", currentAddress)
                .checkResultValue("State and City", userState + " " + userCity);

    }

}
