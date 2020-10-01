$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/ScreenShow.feature");
formatter.feature({
  "name": "To Test the ScreenShow Application",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "To Test the Screen Functionality of ScreenShow",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Open  OnlineMovieTicketSystem",
  "keyword": "Given "
});
formatter.match({
  "location": "com.capg.omts.sreen_show.step_defination.ScreenShowSteps.open_OnlineMovieTicketSystem()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Goto Screen And Click On Add Screen",
  "keyword": "When "
});
formatter.match({
  "location": "com.capg.omts.sreen_show.step_defination.ScreenShowSteps.goto_Screen_And_Click_On_Add_Screen()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Enter ScreenDetails",
  "keyword": "Then "
});
formatter.match({
  "location": "com.capg.omts.sreen_show.step_defination.ScreenShowSteps.enter_ScreenDetails()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click AddScreen Button",
  "keyword": "Then "
});
formatter.match({
  "location": "com.capg.omts.sreen_show.step_defination.ScreenShowSteps.click_AddScreen_Button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Take the Screenshot and the Title",
  "keyword": "Then "
});
formatter.match({
  "location": "com.capg.omts.sreen_show.step_defination.ScreenShowSteps.take_the_Screenshot_and_the_Title()"
});
formatter.result({
  "status": "passed"
});
});