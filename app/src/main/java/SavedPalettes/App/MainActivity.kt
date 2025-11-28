package savedpalettes.app

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvPalettes = findViewById<RecyclerView>(R.id.rvPalettes)
        val btnBack = findViewById<Button>(R.id.btnBack)

        val palettes = listOf(
            Palette(
                name = "Palette 1",
                colors = listOf(
                    Color.parseColor("#0E2724"),
                    Color.parseColor("#B5813F"),
                    Color.parseColor("#A38C75"),
                    Color.parseColor("#6A3B32"),
                    Color.parseColor("#8A3F3F")
                )
            ),
            Palette(
                name = "Palette 2",
                colors = listOf(
                    Color.parseColor("#F6C1FF"),
                    Color.parseColor("#E596FF"),
                    Color.parseColor("#C857FF"),
                    Color.parseColor("#9B20C9"),
                    Color.parseColor("#5E007F")
                )
            ),
            Palette(
                name = "Palette 3",
                colors = listOf(
                    Color.parseColor("#FFC1C1"),
                    Color.parseColor("#FF8A8A"),
                    Color.parseColor("#FF4B4B"),
                    Color.parseColor("#E00000"),
                    Color.parseColor("#A30000")
                )
            )
        )

        rvPalettes.layoutManager = LinearLayoutManager(this)
        rvPalettes.adapter = SavedPalettesAdapter(this, palettes)

        btnBack.setOnClickListener {
            finish()
        }
    }
}
