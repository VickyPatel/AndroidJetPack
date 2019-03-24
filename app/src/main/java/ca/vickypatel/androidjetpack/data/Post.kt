package ca.vickypatel.androidjetpack.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ca.vickypatel.androidjetpack.extras.AppKeys
import ca.vickypatel.androidjetpack.extras.AppKeys.Companion.KEY_USER_ID
import org.jetbrains.annotations.NotNull

@Entity
class Post(
        @NotNull
        @PrimaryKey(autoGenerate = true)
        var id: Int = 0,

        @NotNull
        @ColumnInfo(name = KEY_USER_ID)
        var userId: String = "",

        var title: String = "",
        var body: String = "") {
}