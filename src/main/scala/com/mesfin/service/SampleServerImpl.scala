package com.mesfin.service

import akka.actor.ActorSystem
import akka.event.Logging
import akka.stream.ActorMaterializer
import com.mesfin.config.MicroServiceConfig
import com.swashbuckle.config.SwashbuckleConfig

object SampleServerImpl extends SampleServer with App {

  override implicit lazy val system = ActorSystem()
  override implicit lazy val executor = system.dispatcher
  override implicit lazy val materializer = ActorMaterializer()
  override implicit val routeEc = scala.concurrent.ExecutionContext.global

  override val logger = Logging(system, getClass)
  override val config = MicroServiceConfig
  override val swashbuckleConfig = SwashbuckleConfig.default

  startUp()
}
