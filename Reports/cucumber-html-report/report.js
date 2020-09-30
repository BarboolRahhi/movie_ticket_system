$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/CRMTestCase.feature");
formatter.feature({
  "name": "To Test the Free CRM Application",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "To Test the Login Function of Free CRM",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "To launch the browser and Navigate to the Url",
  "keyword": "Given "
});
formatter.match({
  "location": "com.step_defination.MovieLoginSteps.to_launch_the_browser_and_Navigate_to_the_Url()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To Enter Username and Password",
  "keyword": "When "
});
formatter.match({
  "location": "com.step_defination.MovieLoginSteps.to_Enter_Username_and_Password()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To Click the Submit button",
  "keyword": "Then "
});
formatter.match({
  "location": "com.step_defination.MovieLoginSteps.to_Click_the_Submit_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To Take the Screenshot and the Title",
  "keyword": "Then "
});
formatter.match({
  "location": "com.step_defination.MovieLoginSteps.to_Take_the_Screenshot_and_the_Title()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "To Test the Theatre Function",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "To open add theatre form",
  "keyword": "Given "
});
formatter.match({
  "location": "com.step_defination.MovieTheatreSteps.to_open_add_theatre_form()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "fill theatre form",
  "keyword": "Then "
});
formatter.match({
  "location": "com.step_defination.MovieTheatreSteps.fill_theatre_form()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click Save Button",
  "keyword": "Then "
});
formatter.match({
  "location": "com.step_defination.MovieTheatreSteps.click_Save_Button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Take the Screenshot and the Title",
  "keyword": "Then "
});
formatter.match({
  "location": "com.step_defination.MovieTheatreSteps.take_the_Screenshot_and_the_Title()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Close the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "com.step_defination.MovieTheatreSteps.close_the_browser()"
});
formatter.result({
  "status": "passed"
});
});