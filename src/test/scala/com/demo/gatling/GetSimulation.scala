package com.demo.gatling

import io.gatling.core.Predef._
import io.gatling.http.Predef._

/*
    nothingFor(4 seconds), // 设置一段停止的时间
    atOnceUsers(10), // 立即注入一定数量的虚拟用户
    rampUsers(10) over(5 seconds), // 在指定时间内，设置一定数量逐步注入的虚拟用户
    constantUsersPerSec(20) during(15 seconds), // 定义一个在每秒钟恒定的并发用户数，持续指定的时间
    constantUsersPerSec(20) during(15 seconds) randomized, // 定义一个在每秒钟围绕指定并发数随机增减的并发，持续指定时间
    rampUsersPerSec(10) to 20 during(10 minutes), // 定义一个并发数区间，运行指定时间，并发增长的周期是一个规律的值
    rampUsersPerSec(10) to 20 during(10 minutes) randomized, // 定义一个并发数区间，运行指定时间，并发增长的周期是一个随机的值
    splitUsers(1000) into(rampUsers(10) over(10 seconds)) separatedBy(10 seconds), // 定义一个持续的并发，围绕和海维赛德函数平滑逼近的增长量，持续指定时间（译者解释下海维赛德函数，H(x)当x>0时返回1，x<0时返回0，x=0时返回0.5。实际操作时，并发数是一个成平滑抛物线形的曲线）
    splitUsers(1000) into(rampUsers(10) over(10 seconds)) separatedBy atOnceUsers(30), // 定义一个周期，执行injectionStep里面的注入，将nbUsers的请求平均分配
    heavisideUsers(1000) over(20 seconds) // 使用injectionStep2的注入作为周期，分隔injectionStep1的注入，直到用户数达到nbUsers
 */
class GetSimulation extends Simulation {
  val httpUrl = http.baseURL("http://47.99.240.246:8080/maven_mynetwork")
  val scenarioBuilder = scenario("GetScenario1")
    .during(100){
      exec(
        http("test_myali").get("/home.jsp")
      )}
  setUp(
    scenarioBuilder.inject(atOnceUsers(10))
  ).protocols(httpUrl)
}
