package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {


    private SelenideElement
            inputDateofBirth = $("#dateOfBirthInput"),
            selectYear = $(".react-datepicker__year-select"),
            selectMonth = $(".react-datepicker__month-select");

    @Step("Select date Of birth: {day}:{month}:{year}")
    public void setDate(String day, String month, String year) {

        inputDateofBirth.click();
        selectYear.selectOption(year);
        selectMonth.selectOption(month);
        $(".react-datepicker__day--0" + day).click();

    }

}
