import com.google.gson.annotations.SerializedName

class Game(
    @SerializedName("title") val title:String,
    @SerializedName("thumb") val picture:String
) {
    val description = ""
    override fun toString(): String {
        return "Game Available: \n" +
                "Title:'$title' \n" +
                "Picture:'$picture'\n" +
                "Description:'$description')"

    }

}