package savedpalettes.app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SavedPalettesAdapter(
    private val context: Context,
    private val palettes: List<Palette>
) : RecyclerView.Adapter<SavedPalettesAdapter.PaletteViewHolder>() {

    inner class PaletteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvPaletteName)
        val colorsContainer: LinearLayout = itemView.findViewById(R.id.colorsContainer)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaletteViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.item_palette, parent, false)
        return PaletteViewHolder(view)
    }

    override fun onBindViewHolder(holder: PaletteViewHolder, position: Int) {
        val palette = palettes[position]
        holder.tvName.text = palette.name

        holder.colorsContainer.removeAllViews()

        val density = context.resources.displayMetrics.density
        // fallback height = 24dp if layoutParams is null
        val defaultHeight = (24 * density).toInt()
        val blockHeight = holder.colorsContainer.layoutParams?.height ?: defaultHeight
        val marginPx = (4 * density).toInt()

        palette.colors.forEach { colorInt ->
            val block = View(context)
            val params = LinearLayout.LayoutParams(0, blockHeight)
            params.weight = 1f
            params.setMargins(marginPx, 0, marginPx, 0)
            block.layoutParams = params
            block.setBackgroundColor(colorInt)
            holder.colorsContainer.addView(block)
        }
    }

    override fun getItemCount(): Int = palettes.size
}
