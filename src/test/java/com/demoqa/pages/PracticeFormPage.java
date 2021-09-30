package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormPage {

    private final String NAME_TITLE = "Student Registration Form";
    private final String NAME_TITLE_RESULT = "Thanks for submitting the form";
    private final String URL = "https://demoqa.com/automation-practice-form";
    private SelenideElement
            formTitleLocator = $(".practice-form-wrapper"),
            formTitleResultsLocator = $(".modal-title"),
            firstNameLocator = $("#firstName"),
            lastNameLocator = $("#lastName"),
            emailLocator = $("#userEmail"),
            userGenderLocator = $("#genterWrapper"),
            userMobilePhoneLocator = $("input#userNumber"),
            userSubjectsLocator = $("#subjectsInput"),
            userHobbiesLocator = $("#hobbiesWrapper"),
            tableValueLocator = $(".table-responsive"),
            submitButtonLocator = $("#submit"),
            carrentAdressLocator = $("#currentAddress"),
            userPictureLocator = $("#uploadPicture");

    public SelenideElement
            selectStateLocator = $("#state"),
            selectCityLocator = $("#city"),
            selectSubject = $("#subjectsContainer");

    public CalendarComponent calendar = new CalendarComponent();

    @Step("Open page: {URL} and check title")
    public PracticeFormPage openPage() {
        open(URL);
        formTitleLocator.shouldHave(text(NAME_TITLE));

        return this;
    }

    @Step("Enter First Name: {value}")
    public PracticeFormPage typeFirstName(String value) {
        firstNameLocator.setValue(value);

        return this;
    }

    @Step("Enter Last Name: {value}")
    public PracticeFormPage typeLastName(String value) {
        lastNameLocator.setValue(value);

        return this;
    }

    @Step("Enter Email: {value}")
    public PracticeFormPage typeEmail(String value) {                           // enter email
        emailLocator.setValue(value);

        return this;
    }

    @Step("Select Gender of user: {value}")
    public PracticeFormPage selectGender(String value) {
        userGenderLocator.$(byText(value)).click();

        return this;
    }

    @Step("Enter number of mobilePhone: {number}")
    public PracticeFormPage typeMobilePhone(String number) {
        userMobilePhoneLocator.setValue(number);

        return this;
    }

    @Step("Select subject: {value}")
    public PracticeFormPage selectSubjects(String value) {
        userSubjectsLocator.setValue(value).pressEnter();

        return this;
    }

    @Step("Select user Hobbies: {value}")
    public PracticeFormPage selectHobbies(String value) {
        userHobbiesLocator.$(byText(value)).click();

        return this;
    }

    @Step("Upload Picture: {picturePath}")
    public void uploadPicture(String picturePath) {
        File file = new File(picturePath);
        userPictureLocator.scrollIntoView(true).uploadFile(file);
    }

    @Step("Input Current Address: {address}")
    public void typeCurrentAdress(String address) {
        carrentAdressLocator.setValue(address);
    }

    @Step("Select State: {value}")
    public PracticeFormPage selectState(String value) {
        selectStateLocator.$(byText(value)).click();

        return this;
    }

    @Step("Select City: {value}")
    public PracticeFormPage selectCity(String value) {
        selectCityLocator.$(byText(value)).click();

        return this;
    }

    @Step("Submit data")
    public void submitData() {
        submitButtonLocator.pressEnter();
    }

    @Step("Checking title of results")
    public PracticeFormPage checkTitleResults() {
        formTitleResultsLocator.shouldHave(text(NAME_TITLE_RESULT));

        return this;
    }

    @Step("Checking filled data: {key}:{value}")
    public PracticeFormPage checkResultValue(String key, String value) {
        tableValueLocator.$(byText(key)).parent().shouldHave(text(value));      // checking the fields filled with data

        return this;
    }


}
