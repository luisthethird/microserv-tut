package controllers

import javax.inject.Inject

import play.api.libs.ws.WSClient
import play.api.mvc.{Action, Controller}

import scala.concurrent.{ExecutionContext, Future, Promise}

/**
  * Created by jaimes on 4/13/16.
  */
class WebGateway @Inject() (ws: WSClient) extends Controller {

  import play.api.libs.concurrent.Execution.Implicits._

  def accountRegistration() = Action.async {

    import play.api.libs.json._

    val data = Json.obj(
      "id" -> 1234,
      "name" -> "Pedro the Producer",
      "region" -> "Ethiopia"
    )

    ws.url("http://localhost:9001/account").post(data).map {
      response =>
        Ok(response.json)
    }

  }

  def echoService() = Action.async(parse.json) { request =>
    Future.successful {
      Ok(request.body)
    }
  }

}
