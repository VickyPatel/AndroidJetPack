package ca.vickypatel.androidjetpack

import android.app.Application
import ca.vickypatel.androidjetpack.data.PostRepository

class App : Application() {

    fun getPostRepo(): PostRepository {
        return PostRepository(this)
    }

}

