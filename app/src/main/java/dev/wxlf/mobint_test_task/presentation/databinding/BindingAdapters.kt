package dev.wxlf.mobint_test_task.presentation.databinding

import android.graphics.Color
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("app:url")
    fun loadImage(view: ImageView, url: String) {
        Glide.with(view).load(url).into(view)
    }

    @JvmStatic
    @BindingAdapter("app:textColor")
    fun setTextColor(view: TextView, color: String) {
        view.setTextColor(Color.parseColor(color))
    }

    @JvmStatic
    @BindingAdapter("app:bgColor")
    fun setTextBgColor(view: TextView, color: String) {
        view.background.setTint(Color.parseColor(color))
    }

    @JvmStatic
    @BindingAdapter("app:iconColor")
    fun setIconColor(view: ImageView, color: String) {
        view.setColorFilter(Color.parseColor(color), android.graphics.PorterDuff.Mode.MULTIPLY)
    }

    @JvmStatic
    @BindingAdapter("app:customCardBackgroundColor")
    fun setCardBackgroundColor(view: CardView, color: String) {
        view.setCardBackgroundColor(Color.parseColor(color))
    }
}