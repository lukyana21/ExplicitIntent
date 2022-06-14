package id.lukyana.explicitintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class PindahDenganDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pindah_dengan_data)

        val namaKu: TextView = findViewById(R.id.nama)
        val umurKu: TextView = findViewById(R.id.umur)

        val dataNama = intent.getStringExtra(EXTRA_NAMA)
        val dataUmur = intent.getIntExtra(EXTRA_UMUR, 0)

        namaKu.text = dataNama
        umurKu.text = dataUmur.toString()
    }

    companion object {
        const val EXTRA_NAMA = "EXTRA_NAMA"
        const val EXTRA_UMUR = "EXTRA_UMUR"
    }
}