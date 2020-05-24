package ge.msda.myapplication

data class Note(val Text:String) {

    var id: Int = 0

    companion object {
        var init_Id = 0
    }

    init {
        this.id = ++init_Id
    }
}


