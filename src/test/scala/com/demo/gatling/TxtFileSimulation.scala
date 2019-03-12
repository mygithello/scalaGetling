package com.demo.gatling

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class TxtFileSimulation  extends Simulation{
  val httpUrl = http.baseURL("http://127.0.0.1:7001/xxx")
  //注意这里,设置提交内容type
  val contentType = Map("Content-Type" -> "application/json")
  val scenarioBuilder = scenario("TxtFileScenario")
    .exec(http("txtFileRequest")   //http 请求name
      .post("/xxx/xxx")     //post url
      .headers(contentType)  //设置body数据格式
      //将json参数用StringBody包起,并作为参数传递给function body()
      .body(RawFileBody("json.txt")))
  setUp(scenarioBuilder.inject(atOnceUsers(10))).protocols(httpUrl)
}
