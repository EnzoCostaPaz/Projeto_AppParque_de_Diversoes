
package com.example.woof.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.woof.R

data class Park(
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    val age: Int,
    @StringRes val hobbies: Int
)

val Parks = listOf(
    Park(R.drawable.bate_bate, R.string.brinquedo1, 14, R.string.years_old),
    Park(R.drawable.russa_icon, R.string.brinquedo2, 12, R.string.years_old),
    Park(R.drawable.viking_icon, R.string.brinquedo3, 8, R.string.years_old),
    Park(R.drawable.pula_pula_icon, R.string.brinquedo4, 5, R.string.years_old),
    Park(R.drawable.tobo_agua, R.string.brinquedo5, 16, R.string.years_old),
    Park(R.drawable.xicara_icon, R.string.brinquedo6, 7, R.string.years_old),
    Park(R.drawable.roda_icon, R.string.brinquedo7, 9, R.string.years_old)
)
