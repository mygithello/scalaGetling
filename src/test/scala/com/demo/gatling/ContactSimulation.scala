package com.demo.gatling

import io.gatling.core.Predef._
import io.gatling.http.Predef._

/**
  * form表单提交
  *
  **/
class ContactSimulation extends Simulation{
  val httpUrl = http.baseURL(" http://60.190.249.111:8899/rev_wechatinterface")
  //注意这里,设置提交内容type
  val contentType = Map("Content-Type" -> "application/x-www-form-urlencoded")
  val scenarioBuilder = scenario("FromScenario")
    .during(1){
      exec(
        http("formRequest").post("/merge/manage/find/contactList")
          .headers(contentType)
          .formParam("user_id","000c06738311241ef81a3223fb1b5332")
      )

    }
  setUp(
    scenarioBuilder.inject(atOnceUsers(10))
  ).protocols(httpUrl)
}
