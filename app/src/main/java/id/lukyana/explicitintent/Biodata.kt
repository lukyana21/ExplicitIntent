package id.lukyana.explicitintent

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Biodata(
    val nama: String?,
    val umur: Int?,
    val email: String?,
    val gender: String?
) : Parcelable
