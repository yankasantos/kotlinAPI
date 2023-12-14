import com.google.gson.Gson
import java.lang.NullPointerException
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.util.Scanner


fun main() {
    val readKeyboard = Scanner(System.`in`)
    println("Insert a code of game")
    val search = readKeyboard.nextLine()

    val linkAdress = "https://www.cheapshark.com/api/1.0/games?id=$search"
    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create(linkAdress))
        .build()
    val response = client
        .send(request, BodyHandlers.ofString())
    val json = response.body()
    println(json)

    val gson = Gson()
    val infoGameAvailable = gson.fromJson(json, InfoGame::class.java)

    try {
        val gameAvailable = Game(
            infoGameAvailable.info.title,
            infoGameAvailable.info.thumb)
        println(gameAvailable)
    }catch (ex: NullPointerException){
        println("Jogo inexistent. Tente outro id.")
    }

}