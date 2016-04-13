package controllers

import javax.inject.Inject

import play.api.libs.ws.WSClient
import play.api.mvc.Controller

/**
  * Created by jaimes on 4/13/16.
  */
class WebGateway @Inject() (ws: WSClient) extends Controller {

  def accountRegistration() = {

    import play.api.libs.json._
    val data = Json.obj(
      "key1" -> "value1",
      "key2" -> "value2"
    )
    ws.url("localhost:9001").post(data).map {
      response =>
        Ok(response.json)
    }

  }

}