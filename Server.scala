import com.twitter.finagle.{Http, Service}
import com.twitter.finagle.http
import com.twitter.io.Buf
import com.twitter.util.{Await, Future}

object Server extends App {
  val service = new Service[http.Request, http.Response] {
    def apply(req: http.Request): Future[http.Response] = {
      val resp = http.Response(req.version, http.Status.Ok)
      resp.content = Buf.Utf8("It works!")
      Future.value(resp)
    }
  }

  val server = Http.serve(":8080", service)
  Await.ready(server)
}

