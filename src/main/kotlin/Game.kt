data class Game(
     val title:String,
     val picture:String
) {
    val description = ""
    override fun toString(): String {
        return "Game Available: \n" +
                "Title:'$title' \n" +
                "Picture:'$picture'\n" +
                "Description:'$description')"

    }

}