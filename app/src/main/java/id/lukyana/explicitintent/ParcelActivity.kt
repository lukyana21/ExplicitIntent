package id.lukyana.explicitintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

class ParcelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcel)

        val namaKu: TextView = findViewById(R.id.nama)
        val umurKu: TextView = findViewById(R.id.umur)
        val emailKu: TextView = findViewById(R.id.email)
        val genderKu: TextView = findViewById(R.id.gender)

        val bingkisan = intent.getParcelableExtra<Biodata>(EXTRA_BIODATA) as Biodata
        namaKu.text = bingkisan.nama
        umurKu.text = bingkisan.umur.toString()
        emailKu.text = bingkisan.email
        genderKu.text = bingkisan.gender
    }
    companion object{
        const val EXTRA_BIODATA = "extra_biodata"
    }
}